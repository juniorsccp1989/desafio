package br.com.desafio.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfertaResponseDto {

	private String id;
	
	@JsonProperty("product_id")
	private String productId;
	
	private String name;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	private boolean active;
	private Map<String, Double> coverages;
	private List<String> assistances;
	
	@JsonProperty("monthly_premium_amount")
	private Map<String, Double> monthlyPremiumAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public Map<String, Double> getCoverages() {
		return coverages;
	}

	public void setCoverages(Map<String, Double> coverages) {
		this.coverages = coverages;
	}

	public List<String> getAssistances() {
		return assistances;
	}

	public void setAssistances(List<String> assistances) {
		this.assistances = assistances;
	}

	public Map<String, Double> getMonthlyPremiumAmount() {
		return monthlyPremiumAmount;
	}

	public void setMonthlyPremiumAmount(Map<String, Double> monthlyPremiumAmount) {
		this.monthlyPremiumAmount = monthlyPremiumAmount;
	}
}
