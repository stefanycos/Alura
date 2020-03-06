package br.com.alura.microservice.store.service.dto;

import java.time.LocalDate;

public class VoucherDTO {

	private Long number;

	private LocalDate forecastDelivery;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public LocalDate getForecastDelivery() {
		return forecastDelivery;
	}

	public void setForecastDelivery(LocalDate forecastDelivery) {
		this.forecastDelivery = forecastDelivery;
	}

}
