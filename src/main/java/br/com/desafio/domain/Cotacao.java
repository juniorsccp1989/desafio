package br.com.desafio.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import org.springframework.data.relational.core.mapping.MappedCollection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cotacao")
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "insurance_policy_id")
	private Long insurancePolicyId;

    @Column(name = "product_id")
	private String productId;

    @Column(name = "offer_id")
	private String offerId;

	private String category;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "total_monthly_premium_amount")
	private Double totalMonthlyPremiumAmount;

	@Column(name = "total_coverage_amount")
	private Double totalCoverageAmount;

	@OneToMany(mappedBy = "cotacao", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Coverage> coverages;
	
	@OneToMany(mappedBy = "cotacao", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Assistance> assistances;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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
	public List<Coverage> getCoverages() {
		return coverages;
	}

	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}

	public List<Assistance> getAssistances() {
		return assistances;
	}

	public void setAssistances(List<Assistance> assistances) {
		this.assistances = assistances;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
