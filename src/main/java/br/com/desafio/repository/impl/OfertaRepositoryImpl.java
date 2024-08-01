package br.com.desafio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.dtos.OfertaResponseDto;
import br.com.desafio.repository.OfertaRepository;

@Repository
public class OfertaRepositoryImpl implements OfertaRepository{
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoRepositoryImpl.class);
	
	private static final String URL_CONSULTA_OFERTA = "http://localhost:1080/desafio/offers";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public OfertaResponseDto getOferta(String id) {
		OfertaResponseDto ofertaResponse = null;
		String url = URL_CONSULTA_OFERTA + "/" + id;
		try{
			String json = restTemplate.getForObject(url, String.class);
			ofertaResponse =  objectMapper.readValue(json, OfertaResponseDto.class);
		} catch(HttpClientErrorException ex) {
			logger.error("Não existe oferta com o id " + id);	
		} catch(Exception e){
			logger.error("Houve um erro ao converter o json da consulta de oferta!");
		} 
		return ofertaResponse;
	}
}
