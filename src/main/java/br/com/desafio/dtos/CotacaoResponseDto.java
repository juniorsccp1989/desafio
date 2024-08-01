package br.com.desafio.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.desafio.domain.Customer;

public class CotacaoResponseDto {

	private Long id;
	
	@JsonProperty("insurance_policy_id")
	private Long insurancePolicyId;
	
	@JsonProperty("product_id")
	private String productId;
	
	@JsonProperty("offer_id")
	private String offerId;
	
	private String category;

	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	
	@JsonProperty("updated_at")
	private LocalDateTime updateAt;
	
	@JsonProperty("total_monthly_premium_amount")
	private Double totalMonthlyPremiumAmount;
	
	@JsonProperty("total_coverage_amount")
	private Double totalCoverageAmount;
	
	private Map<String, Double> coverages;
	
	private List<String> assistances;
	
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInsurancePolicyId() {
		return insurancePolicyId;
	}

	public void setInsurancePolicyId(Long insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public Double getTotalMonthlyPremiumAmount() {
		return totalMonthlyPremiumAmount;
	}

	public void setTotalMonthlyPremiumAmount(Double totalMonthlyPremiumAmount) {
		this.totalMonthlyPremiumAmount = totalMonthlyPremiumAmount;
	}

	public Double getTotalCoverageAmount() {
		return totalCoverageAmount;
	}

	public void setTotalCoverageAmount(Double totalCoverageAmount) {
		this.totalCoverageAmount = totalCoverageAmount;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
