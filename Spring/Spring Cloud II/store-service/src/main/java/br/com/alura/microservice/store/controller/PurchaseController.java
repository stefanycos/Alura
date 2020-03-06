package br.com.alura.microservice.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

	@GetMapping("/{id}")
	public Purchase read(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
