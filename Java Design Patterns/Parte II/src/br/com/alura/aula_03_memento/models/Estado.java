package br.com.alura.aula_03_memento.models;

public class Estado {

	private Contrato contrato;

	public Estado(Contrato contrato) {
		this.contrato = contrato;
	}

	public Contrato getContrato() {
		return contrato;
	}
}