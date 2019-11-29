package br.com.alura.microservice.store.controller.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyDTO {

	private List<ItemDTO> itens; 
	
	private AddressDTO addressDTO;
}
