package br.com.alura.aula_07_command.models;

import java.time.LocalDateTime;

public class Pedido {

	private String cliente;

	private double valor;

	private Status status;

	private LocalDateTime dataFinalizacao;

	public Pedido(String cliente, double valor) {
		this.cliente = cliente;
		this.valor = valor;
		this.status = Status.NOVO;
	}

	public void paga() {
		this.status = Status.PAGO;
	}

	public void finaliza() {
		this.status = Status.ENTREGUE;
		this.dataFinalizacao = LocalDateTime.now();
	}

	public String getCliente() {
		return cliente;
	}

	public double getValor() {
		return valor;
	}

	public Status getStatus() {
		return status;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

}
