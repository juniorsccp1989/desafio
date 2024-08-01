package br.com.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.Cotacao;
import br.com.desafio.dtos.CotacaoRequestDto;	

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, Long>{

	void save(CotacaoRequestDto cotacao);
	
}
