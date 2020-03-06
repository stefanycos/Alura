package br.com.alura.microservice.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservice.store.service.dto.DeliveryInfoDTO;
import br.com.alura.microservice.store.service.dto.VoucherDTO;

@FeignClient(name = "transporter")
public interface TransporterClient {

	@PostMapping(path = "/delivery")
	public VoucherDTO bookDelivery(@RequestBody DeliveryInfoDTO orderDTO);

}
