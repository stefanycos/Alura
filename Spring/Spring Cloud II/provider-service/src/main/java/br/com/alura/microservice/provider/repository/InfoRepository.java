package br.com.alura.microservice.provider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.provider.models.ProviderInfo;

@Repository
public interface InfoRepository extends CrudRepository<ProviderInfo, Long> {

	ProviderInfo findByState(String state);
}
