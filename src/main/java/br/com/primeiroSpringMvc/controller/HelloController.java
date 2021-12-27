package br.com.primeiroSpringMvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.primeiroSpringMvc.dto.ProductDto;
import br.com.primeiroSpringMvc.model.Product;
import br.com.primeiroSpringMvc.repository.ProductReposittory;

@Controller
public class HelloController {
	
	private ProductReposittory productRepository;
	
	@Autowired
	public HelloController(ProductReposittory productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "index";
	}
	
	@GetMapping("register")
	public String register() {
		return "register";
	}
	
	@PostMapping("register")
	public String register(@Valid ProductDto obj, BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:register";
		}
		
		Product product = obj.toProduct();
		productRepository.save(product);
		return "redirect:/";
	}
	
	@GetMapping("update/{id}")
	public String formUpdate(Model model,@PathVariable Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
		model.addAttribute("product", product);
		return "update";
	}
	
	@PostMapping("update")
	public String update(ProductDto obj) {
		Product product = obj.toProduct();
		productRepository.save(product);
		return "redirect:/";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		productRepository.deleteById(id);
		return "redirect:/";
	}
	
	/*public RedirectView search() {
		
	}*/
}
