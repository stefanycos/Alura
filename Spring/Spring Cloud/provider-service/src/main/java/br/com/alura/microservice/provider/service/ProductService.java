package br.com.alura.microservice.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.models.Product;
import br.com.alura.microservice.provider.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductsByState(String estado) {
		return productRepository.findByState(estado);
	}

}
