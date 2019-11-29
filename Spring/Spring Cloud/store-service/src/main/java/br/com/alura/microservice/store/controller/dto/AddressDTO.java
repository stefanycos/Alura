package br.com.alura.microservice.store.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

	private String publicPlace;

	private Integer number;

	private String state;

}
