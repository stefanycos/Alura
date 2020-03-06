package br.com.alura.microservice.transportador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.transportador.dto.DeliveryDTO;
import br.com.alura.microservice.transportador.dto.VoucherDTO;
import br.com.alura.microservice.transportador.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@PostMapping
	public VoucherDTO bookDelivery(@RequestBody DeliveryDTO orderDTO) {
		return deliveryService.reservaEntrega(orderDTO);
	}
}
