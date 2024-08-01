package br.com.desafio.domain;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assistance")
public class Assistance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_assistance")
	private String nomeAssistance;
	
    @ManyToOne
    @JoinColumn(name = "cotacao_id")
    @JsonBackReference
    private Cotacao cotacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAssistance() {
		return nomeAssistance;
	}

	public void setNomeAssistance(String nomeAssistance) {
		this.nomeAssistance = nomeAssistance;
	}

//	public Long getCotacaoId() {
//		return cotacaoId;
//	}
//
//	public void setCotacaoId(Long cotacaoId) {
//		this.cotacaoId = cotacaoId;
//	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
}
