package br.com.desafio.repository;

import br.com.desafio.dtos.OfertaResponseDto;

public interface OfertaRepository {
	
	OfertaResponseDto getOferta(String id);

}
