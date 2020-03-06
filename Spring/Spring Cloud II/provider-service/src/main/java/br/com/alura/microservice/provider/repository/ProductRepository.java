package br.com.alura.microservice.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.microservice.provider.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findByState(String state);
	
	List<Product> findByIdIn(List<Long> ids);
}
