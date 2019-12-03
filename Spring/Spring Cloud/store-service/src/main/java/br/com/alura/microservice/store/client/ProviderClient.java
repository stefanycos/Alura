package br.com.alura.microservice.store.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.microservice.store.controller.dto.ItemDTO;
import br.com.alura.microservice.store.controller.dto.OrderInfoDTO;
import br.com.alura.microservice.store.controller.dto.ProviderInfoDTO;

@FeignClient(name = "provider", path = "/api/v1")
public interface ProviderClient {

	@GetMapping(path = "/info/{state}")
	ProviderInfoDTO getInfoByState(@PathVariable("state") String state);

	@PostMapping(path = "/order")
	OrderInfoDTO realizeOrder(List<ItemDTO> itens);
	
}
