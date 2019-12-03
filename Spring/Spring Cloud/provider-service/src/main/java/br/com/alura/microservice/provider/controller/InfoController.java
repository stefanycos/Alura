package br.com.alura.microservice.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.models.ProviderInfo;
import br.com.alura.microservice.provider.service.InfoService;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {
	
	@Autowired
	private InfoService service;

	
	@GetMapping("/{state}")
	public ProviderInfo infoByState(@PathVariable String state) {
		return service.getInfoByState(state);
	}
}
