package br.com.alura.microservice.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.models.Product;
import br.com.alura.microservice.provider.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{state}")
	public List<Product> getProdutosPorEstado(@PathVariable("state") String state) {
		return productService.getProductsByState(state);
	}
}
