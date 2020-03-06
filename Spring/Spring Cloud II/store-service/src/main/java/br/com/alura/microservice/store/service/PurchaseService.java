package br.com.alura.microservice.store.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservice.store.client.ProviderClient;
import br.com.alura.microservice.store.client.TransporterClient;
import br.com.alura.microservice.store.controller.dto.OrderInfoDTO;
import br.com.alura.microservice.store.controller.dto.ProviderInfoDTO;
import br.com.alura.microservice.store.controller.dto.PurchaseDTO;
import br.com.alura.microservice.store.repository.PurchaseRepository;
import br.com.alura.microservice.store.service.dto.DeliveryInfoDTO;
import br.com.alura.microservice.store.service.dto.VoucherDTO;
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
	
	@Autowired
	private TransporterClient transporterClient;

	@Autowired
	private PurchaseRepository purchaseRepository;

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

	@HystrixCommand(fallbackMethod = "purchaseFallback", threadPoolKey = "doPurchaseThreadPool")
	public Purchase purchase(PurchaseDTO requestBody) {
		LOGGER.info("Seraching data at provider service, state [{}]", requestBody.getAddress().getState());
		ProviderInfoDTO providerInfoDTO = providerClient.getInfoByState(requestBody.getAddress().getState());

		LOGGER.info("Data retrieved [{}]", providerInfoDTO);

		OrderInfoDTO order = providerClient.realizeOrder(requestBody.getItens());
		
		DeliveryInfoDTO deliveryDTO = new DeliveryInfoDTO();
		deliveryDTO.setOrderId(order.getId());
		deliveryDTO.setDeliveryDate(LocalDate.now().plusDays(order.getPreparationTime()));
		deliveryDTO.setSourceAddress(providerInfoDTO.getAddress());
		deliveryDTO.setDestinationAddress(requestBody.getAddress().getPublicPlace() + " | " + requestBody.getAddress().getState());
		
		VoucherDTO voucher = transporterClient.bookDelivery(deliveryDTO);

		LOGGER.info("Creating order at provider service...");
		Purchase purchase = Purchase.builder() // @formatter:off
								.address(requestBody.getAddress().getPublicPlace() + " | " + requestBody.getAddress().getState())
								.orderId(order.getId())
								.preparationTime(order.getPreparationTime()).build(); // @formatter:on
		
		purchase.setDeliveryDate(voucher.getForecastDelivery());
		purchase.setVoucher(voucher.getNumber());
		
		LOGGER.info("Order created successfully!");
		purchase.create();
		purchaseRepository.save(purchase);

		return purchase;
	}

	@HystrixCommand(threadPoolKey = "findByIdThreadPool")
	public Optional<Purchase> findById(Long id) {
		return purchaseRepository.findById(id);
	}

	public Purchase purchaseFallback(PurchaseDTO requestBody) {
		Purchase purchase = Purchase.builder().build();
		purchase.error();

		return purchase;
	}
}
