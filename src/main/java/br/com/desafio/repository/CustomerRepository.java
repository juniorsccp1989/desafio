package br.com.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.Customer;
import br.com.desafio.dtos.CotacaoRequestDto;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	void save(CotacaoRequestDto cotacao);

}
