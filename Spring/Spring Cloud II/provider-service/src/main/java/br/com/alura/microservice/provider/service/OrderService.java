package br.com.alura.microservice.provider.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.dto.OrderItemDTO;
import br.com.alura.microservice.provider.models.Order;
import br.com.alura.microservice.provider.models.OrderItem;
import br.com.alura.microservice.provider.models.Product;
import br.com.alura.microservice.provider.repository.OrderRepository;
import br.com.alura.microservice.provider.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public Order realizeOrder(List<OrderItemDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<OrderItem> pedidoItens = toOrderItem(itens);
		Order order = new Order(pedidoItens);
		order.setPreparationTime(itens.size());
		return orderRepository.save(order);
	}
	
	public Order getOrderById(Long id) {
		return this.orderRepository.findById(id).orElse(new Order());
	}

	private List<OrderItem> toOrderItem(List<OrderItemDTO> itens) {
		
		List<Long> idsProdutos = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> produtosDoPedido = productRepository.findByIdIn(idsProdutos);
		
		List<OrderItem> pedidoItens = itens
			.stream()
			.map(item -> {
				Product product = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				OrderItem pedidoItem = new OrderItem();
				pedidoItem.setProduct(product);
				pedidoItem.setQuantity(item.getQuantity());
				return pedidoItem;
				}).collect(Collectors.toList());
		
		return pedidoItens;
	}
}
