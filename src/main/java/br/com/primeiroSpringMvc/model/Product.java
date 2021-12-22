package br.com.primeiroSpringMvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal value;
	private LocalDate deliveryDate;
	
	@Column(length = 500)
	private String productUrl;
	
	@Column(length = 1000)
	private String description;
	
	public Product() {
	}

	public Product(Long id, String name, BigDecimal value, LocalDate deliveryDate, String productUrl,
			String description) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.deliveryDate = deliveryDate;
		this.productUrl = productUrl;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void Long(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
