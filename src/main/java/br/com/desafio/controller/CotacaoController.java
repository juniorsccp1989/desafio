package br.com.desafio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.desafio.domain.Cotacao;
import br.com.desafio.dtos.CotacaoRequestDto;
import br.com.desafio.exception.CotacaoException;
import br.com.desafio.service.CotacaoService;

@Controller
@RequestMapping("/desafio/itau/cotacao")
public class CotacaoController {
	
	@Autowired
	private CotacaoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Cotacao> cotacao(
			@PathVariable Long id) throws CotacaoException {
		Optional<Cotacao> cotacao = service.consultar(id);
		if(cotacao.isEmpty()) {
			throw new CotacaoException("Cotação não encontrada com esse id");
		}
		return ResponseEntity.ok(cotacao.get());
	}
	
	@PostMapping
	public ResponseEntity<String> cotacao(
			@RequestBody CotacaoRequestDto cotacao) throws CotacaoException {
		service.gravar(cotacao);
		return ResponseEntity.ok("Cotação gravada com sucesso!");
	}
}
