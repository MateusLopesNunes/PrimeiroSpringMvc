package br.com.primeiroSpringMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeiroSpringMvc.model.Product;

public interface ProductReposittory extends JpaRepository<Product, Long>{
	
}
