package br.com.alura.microservice.transportador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.transportador.dto.DeliveryDTO;
import br.com.alura.microservice.transportador.dto.VoucherDTO;
import br.com.alura.microservice.transportador.model.Delivery;
import br.com.alura.microservice.transportador.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository repository;

	public VoucherDTO reservaEntrega(DeliveryDTO deliveryDTO) {

		Delivery delivery = new Delivery();
		delivery.setTakeDate(deliveryDTO.getDeliveryDate());
		delivery.setDeliveryForecast(deliveryDTO.getDeliveryDate().plusDays(1));
		delivery.setDestinationAddress(deliveryDTO.getDestinationAddress());
		delivery.setSourceAddress(deliveryDTO.getSourceAddress());
		delivery.setId(deliveryDTO.getOrderId());

		repository.save(delivery);

		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumber(delivery.getId());
		voucher.setForecastDelivery(deliveryDTO.getDeliveryDate());

		return voucher;
	}

}
