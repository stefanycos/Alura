package br.com.alura.aula_03_template_method.models;

public class Item {

	private String nome;
	private double valor;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

}
