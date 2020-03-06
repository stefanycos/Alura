package br.com.alura.microservice.provider.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.microservice.provider.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
