package br.com.desafio.repository;

import br.com.desafio.dtos.ProdutoResponseDto;

public interface ProdutoRepository {

	ProdutoResponseDto getProduto(String id);
}
