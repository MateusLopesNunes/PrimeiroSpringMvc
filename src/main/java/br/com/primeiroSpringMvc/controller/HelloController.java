package br.com.primeiroSpringMvc.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import br.com.primeiroSpringMvc.model.Product;
import br.com.primeiroSpringMvc.repository.ProductReposittory;

@Controller
public class HelloController {
	
	private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private ProductReposittory productRepository;
	
	@Autowired
	public HelloController(ProductReposittory productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/")
	public String index(HttpServletRequest request) {
		List<Product> products = productRepository.findAll();
		request.setAttribute("products", products);
		return "index";
	}
	
	@GetMapping("register")
	public String register() {
		return "register";
	}
	
	@PostMapping("register")
	public RedirectView register(HttpServletRequest request) {
		String name = request.getParameter("name");
		BigDecimal value = new BigDecimal(request.getParameter("value"));
		LocalDate deliveryDate = LocalDate.parse(request.getParameter("deliveryDate"), DATE_FORMATTER);
		String productUrl = request.getParameter("productUrl");
		String description = request.getParameter("description");
		
		Product product = new Product(null, name, value, deliveryDate, productUrl, description);
		productRepository.save(product);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");
		return redirectView;
	}
	
	@GetMapping("update/{id}")
	public String formUpdate(HttpServletRequest request,@PathVariable Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
		request.setAttribute("product", product);
		return "update";
	}
	
	@PostMapping("update")
	public RedirectView update(HttpServletRequest request) {
		String name = request.getParameter("name");
		BigDecimal value = new BigDecimal(request.getParameter("value"));
		LocalDate deliveryDate = LocalDate.parse(request.getParameter("deliveryDate"), DATE_FORMATTER);
		String productUrl = request.getParameter("productUrl");
		String description = request.getParameter("description");
		
		Product product = new Product(null, name, value, deliveryDate, productUrl, description);
		productRepository.save(product);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");
		return redirectView;
	}
	
	@GetMapping("delete/{id}")
	public RedirectView delete(@PathVariable Long id) {
		productRepository.deleteById(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");
		return redirectView;
	}
	
	/*public RedirectView search() {
		
	}*/
}
