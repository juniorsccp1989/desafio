package br.com.desafio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.dtos.ProdutoResponseDto;
import br.com.desafio.repository.ProdutoRepository;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoRepositoryImpl.class);
	
	private static final String URL_CONSULTA_PRODUTO = "http://localhost:1080/desafio/product";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ProdutoResponseDto getProduto(String id) {
		ProdutoResponseDto produtoResponse = null;
		String url = URL_CONSULTA_PRODUTO + "/" + id;
		try{
			String json = restTemplate.getForObject(url, String.class);
			produtoResponse =  objectMapper.readValue(json, ProdutoResponseDto.class);
		} catch(HttpClientErrorException ex) {
			logger.error("Não existe produto com o id " + id);
		} catch(Exception e){
			logger.error("Houve um erro ao converter o json da consulta de produto!");
		}
		return produtoResponse;
	}

}
