package br.com.alura.microservice.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.store.controller.dto.PurchaseDTO;
import br.com.alura.microservice.store.service.PurchaseService;
import br.com.alura.microservice.store.service.models.Purchase;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService service;

	@PostMapping
	public Purchase create(@RequestBody PurchaseDTO requestBody) {
		return service.purchase(requestBody);
	}
}
