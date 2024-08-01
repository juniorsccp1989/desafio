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

//@Table("coverage")
@Entity
@Table(name = "coverage")
public class Coverage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_coverage")
	private String nomeCoverage;
	
	@Column(name = "vl_coverage")
	private Double vlCoverage;
	
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

	public String getNomeCoverage() {
		return nomeCoverage;
	}

	public void setNomeCoverage(String nomeCoverage) {
		this.nomeCoverage = nomeCoverage;
	}

	public Double getVlCoverage() {
		return vlCoverage;
	}

	public void setVlCoverage(Double vlCoverage) {
		this.vlCoverage = vlCoverage;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

//	public Long getCotacaoId() {
//		return cotacaoId;
//	}
//
//	public void setCotacaoId(Long cotacaoId) {
//		this.cotacaoId = cotacaoId;
//	}
	
}
