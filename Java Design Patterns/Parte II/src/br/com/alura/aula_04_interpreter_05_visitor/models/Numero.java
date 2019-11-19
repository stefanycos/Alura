package br.com.alura.aula_04_interpreter_05_visitor.models;

public class Numero implements Expressao {

	private int numero; // NOSONAR

	public Numero(int numero) {
		this.numero = numero;
	}

	@Override
	public int calcula() {
		return numero;
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaNumero(this);
	}

	public int getNumero() {
		return numero;
	}

}
