package br.com.desafio.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResponseDto {

	private String id;
	private String name;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	private boolean active;
	private List<String> offers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<String> getOffers() {
		return offers;
	}
	public void setOffers(List<String> offers) {
		this.offers = offers;
	}
}
