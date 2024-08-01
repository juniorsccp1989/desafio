package br.com.desafio.service;

import java.util.Optional;

import br.com.desafio.domain.Cotacao;
import br.com.desafio.dtos.CotacaoRequestDto;
import br.com.desafio.exception.CotacaoException;

public interface CotacaoService {

	void gravar(CotacaoRequestDto cotacao) throws CotacaoException;
	
	Optional<Cotacao> consultar(Long id);
	
}
