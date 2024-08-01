package br.com.desafio.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.domain.Assistance;
import br.com.desafio.domain.Cotacao;
import br.com.desafio.domain.Coverage;
import br.com.desafio.dtos.CotacaoRequestDto;
import br.com.desafio.dtos.OfertaResponseDto;
import br.com.desafio.dtos.ProdutoResponseDto;
import br.com.desafio.exception.CotacaoException;
import br.com.desafio.repository.CotacaoRepository;
import br.com.desafio.repository.CustomerRepository;
import br.com.desafio.repository.OfertaRepository;
import br.com.desafio.repository.ProdutoRepository;
import br.com.desafio.service.CotacaoService;
import br.com.desafio.utils.ActiveMQProducer;

@Service
public class CotacaoServiceImpl implements CotacaoService {
	
	private static final Logger logger = LoggerFactory.getLogger(CotacaoServiceImpl.class);
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Autowired
	private CotacaoRepository cotacaoRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ActiveMQProducer activeMQProducer;

	@Override
	public void gravar(CotacaoRequestDto cotacaoRequest) throws CotacaoException {
		this.validaCotacao(cotacaoRequest);
		Cotacao cotacao = this.mapearCotacao(cotacaoRequest);
		this.customerRepository.save(cotacao.getCustomer());
		this.cotacaoRepository.save(cotacao);
		activeMQProducer.sendMessage(cotacao.toString());
	}
	
	private void validaCotacao(CotacaoRequestDto cotacao) throws CotacaoException {
		ProdutoResponseDto produto =  produtoRepository.getProduto(cotacao.getProductId());
		if(Objects.isNull(produto) || !produto.isActive()) {
			logger.error("Produto não existe ou está inativo!");
			throw new CotacaoException("Produto não existe ou está inativo!");
		}
		OfertaResponseDto oferta = ofertaRepository.getOferta(cotacao.getOfferId());
		if(Objects.isNull(oferta) || !oferta.isActive()) {
			logger.error("Oferta não existe ou está inativa!");
			throw new CotacaoException("Oferta não existe ou está inativa!");
		}
		
		double vlTotalCoverages = 0;
		
		for(Map.Entry<String, Double> entry : cotacao.getCoverages().entrySet()) {
			vlTotalCoverages += entry.getValue();
            if(oferta.getCoverages().containsKey(entry.getKey())){
            	Double vlCoverage = oferta.getCoverages().get(entry.getKey());
            	if(vlCoverage < entry.getValue()) {
            		logger.error("O valor da cobertura " + entry.getKey() + " está acima do permitido pela oferta!");
            		throw new CotacaoException("O valor da cobertura \" + entry.getKey() + \" está acima do permitido pela oferta!");
            	}
            }
        }
		
		if(vlTotalCoverages != cotacao.getTotalCoverageAmount()) {
			logger.error("O valor total das coberturas não corresponde ao valor total informado no corpo da requisição!");
			throw new CotacaoException("O valor total das coberturas não corresponde ao valor total informado no corpo da requisição!");
		}
		
		for(String assistance : cotacao.getAssistances()) {
			if(!oferta.getAssistances().contains(assistance)) {
				logger.error("A assistência " + assistance + " não está dentro da lista de assistências da oferta!");
				throw new CotacaoException("A assistência \" + assistance + \" não está dentro da lista de assistências da oferta!");
			}
		}
		
		double vlMaximoAmmount = oferta.getMonthlyPremiumAmount().get("max_amount");
		double vlMinimoAmmount = oferta.getMonthlyPremiumAmount().get("min_amount");
			
		if(cotacao.getTotalMonthlyPremiumAmount() < vlMinimoAmmount 
				|| cotacao.getTotalMonthlyPremiumAmount() > vlMaximoAmmount) {
			logger.error("O valor total do prêmio mensal está fora dos limites estabelecidos para a oferta!");
			throw new CotacaoException("O valor total do prêmio mensal está fora dos limites estabelecidos para a oferta!");
		}
	}
	
	public Cotacao mapearCotacao(CotacaoRequestDto cotacaoRequestDto) {
		Cotacao cotacao = new Cotacao();
		cotacao.setCategory(cotacaoRequestDto.getCategory());
		cotacao.setCreatedAt(LocalDateTime.now());
		cotacao.setOfferId(cotacaoRequestDto.getOfferId());
		cotacao.setProductId(cotacaoRequestDto.getProductId());
		cotacao.setTotalCoverageAmount(cotacaoRequestDto.getTotalCoverageAmount());
		cotacao.setTotalMonthlyPremiumAmount(cotacaoRequestDto.getTotalMonthlyPremiumAmount());
		cotacao.setCustomer(cotacaoRequestDto.getCustomer());
		this.mapearAssistencia(cotacaoRequestDto.getAssistances(), cotacao);
		this.mapearCoverages(cotacaoRequestDto.getCoverages(), cotacao);
		return cotacao;
	}
	
	public void mapearAssistencia(List<String> nomeAssistencias, Cotacao cotacao) {
		List<Assistance> lsAssistance = new ArrayList<>();
		for (String nomeAssistencia : nomeAssistencias) {
			Assistance assistance = new Assistance();
			assistance.setCotacao(cotacao);
			assistance.setNomeAssistance(nomeAssistencia);
			lsAssistance.add(assistance);
		}
		cotacao.setAssistances(lsAssistance);
	}
	
	public void mapearCoverages(Map<String, Double> coverages, Cotacao cotacao) {
		List<Coverage> lsCoverages = new ArrayList<>();
		for(Map.Entry<String, Double> entry : coverages.entrySet()) {
			Coverage coverage = new Coverage();
			coverage.setNomeCoverage(entry.getKey());
			coverage.setVlCoverage(entry.getValue());
			coverage.setCotacao(cotacao);
			lsCoverages.add(coverage);
        }
		cotacao.setCoverages(lsCoverages);
	}

	@Override
	public Optional<Cotacao> consultar(Long id) {
		return cotacaoRepository.findById(id);
	}
}
