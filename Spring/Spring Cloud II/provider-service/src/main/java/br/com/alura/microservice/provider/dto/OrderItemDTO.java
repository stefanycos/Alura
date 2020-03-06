package br.com.alura.microservice.provider.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

	private long id;
	
	private int quantity;

}
