package br.com.primeiroSpringMvc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;

import br.com.primeiroSpringMvc.model.Product;

public class ProductDto {

	private Long id;
	
	@NotBlank
	private String name;
	
	private BigDecimal value;
	
	@NotBlank
	private String deliveryDate;
	
	@NotBlank
	private String productUrl;
	
	@NotBlank
	private String description;
	
	public ProductDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
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

	public Product toProduct() {
		Product product = new Product(id, name, value, LocalDate.parse(deliveryDate), productUrl, description);
		return product;
	}
}
