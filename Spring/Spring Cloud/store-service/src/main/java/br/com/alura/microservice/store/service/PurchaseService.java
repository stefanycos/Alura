package br.com.alura.microservice.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.store.client.ProviderClient;
import br.com.alura.microservice.store.controller.dto.OrderInfoDTO;
import br.com.alura.microservice.store.controller.dto.ProviderInfoDTO;
import br.com.alura.microservice.store.controller.dto.PurchaseDTO;
import br.com.alura.microservice.store.service.models.Purchase;

@Service
public class PurchaseService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private RestTemplate client;

	@Autowired
	private DiscoveryClient eurekaClient;

	@Autowired
	private ProviderClient providerClient;

	public ProviderInfoDTO purchaseWithRestTemplate(PurchaseDTO requestBody) {
		String state = requestBody.getAddress().getState();

		ResponseEntity<ProviderInfoDTO> responseEntity = client.exchange("http://provider/api/v1/info/" + state,
				HttpMethod.GET, null, ProviderInfoDTO.class);

		// List available instances of provider service
		eurekaClient.getInstances("provider").stream().forEach(provider -> {
			System.out.println("localhost:" + provider.getPort());
		});

		return responseEntity.getBody();

	}

	public Purchase purchase(PurchaseDTO requestBody) {
		LOGGER.info("Seraching data at provider service, state [{}]", requestBody.getAddress().getState());
		ProviderInfoDTO providerInfoDTO = providerClient.getInfoByState(requestBody.getAddress().getState());

		LOGGER.info("Data retrieved [{}]", providerInfoDTO);

		OrderInfoDTO order = providerClient.realizeOrder(requestBody.getItens());
		
		LOGGER.info("Creating order at provider service...");
		Purchase purchase = Purchase.builder() // @formatter:off
								.address(requestBody.getAddress().toString())
								.orderId(order.getId())
								.preparationTime(order.getPreparationTime()).build(); // @formatter:on
		
		LOGGER.info("Order created successfully!");
		return purchase;
	}

}
