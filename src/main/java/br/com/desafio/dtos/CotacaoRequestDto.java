package br.com.desafio.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.desafio.domain.Customer;

public class CotacaoRequestDto {

	@JsonProperty("product_id")
	private String productId;
	
	@JsonProperty("offer_id")
	private String offerId;
	
	private String category;
	
	@JsonProperty("total_monthly_premium_amount")
	private Double totalMonthlyPremiumAmount;
	
	@JsonProperty("total_coverage_amount")
	private Double totalCoverageAmount;
	
	private Map<String, Double> coverages;
	
	private List<String> assistances;
	
	private Customer customer;
	
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
