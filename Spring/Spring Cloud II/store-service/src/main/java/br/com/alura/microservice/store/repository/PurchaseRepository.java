package br.com.alura.microservice.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.store.service.models.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}
