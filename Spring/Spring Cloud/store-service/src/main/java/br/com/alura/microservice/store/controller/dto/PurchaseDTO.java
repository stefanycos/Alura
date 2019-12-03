package br.com.alura.microservice.store.controller.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurchaseDTO {

	private List<ItemDTO> itens; 
	
	private AddressDTO address;
}
