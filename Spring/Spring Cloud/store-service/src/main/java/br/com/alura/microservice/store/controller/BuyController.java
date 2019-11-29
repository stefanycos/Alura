package br.com.alura.microservice.store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.store.controller.dto.BuyDTO;

@RestController
@RequestMapping("api/v1/buy")
public class BuyController {

	@PostMapping
	public void create(@RequestBody BuyDTO requestBody) {
		
	}
}
