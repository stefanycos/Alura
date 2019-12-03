package br.com.alura.microservice.store.service.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Purchase {

	private Long orderId;

	private Integer preparationTime;

	private String address;

}
