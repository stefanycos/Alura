package br.com.alura.microservice.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.dto.OrderItemDTO;
import br.com.alura.microservice.provider.models.Order;
import br.com.alura.microservice.provider.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public Order realizaPedido(@RequestBody List<OrderItemDTO> products) {
		return orderService.realizeOrder(products);
	}

	@GetMapping("/{id}")
	public Order getPedidoPorId(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
}
