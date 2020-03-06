package br.com.alura.microservice.store.service.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

	@Id
	private Long orderId;

	private Integer preparationTime;

	private String address;

	private PurshaseStatus status;
	
	private LocalDate deliveryDate;
	
	private Long voucher;

	public void end() {
		this.status = PurshaseStatus.FINISHED;
	}

	public void process() {
		this.status = PurshaseStatus.PROCESSING;
	}

	public void create() {
		this.status = PurshaseStatus.CREATED;
	}

	public void error() {
		this.status = PurshaseStatus.ERROR;
	}

}
