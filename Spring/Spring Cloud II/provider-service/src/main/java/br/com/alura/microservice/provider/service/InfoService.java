package br.com.alura.microservice.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.models.ProviderInfo;
import br.com.alura.microservice.provider.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository repository;
	
	public ProviderInfo getInfoByState(String state) {
		return repository.findByState(state);
	}

}
