package br.com.alura.aula_04_interpreter_05_visitor.models;

public class Subtracao implements Expressao {

	private Expressao direira;
	private Expressao esquerda;

	public Subtracao(Expressao direira, Expressao esquerda) {
		this.direira = direira;
		this.esquerda = esquerda;
	}

	@Override
	public int calcula() {
		int resultadoDireita = direira.calcula();
		int resultadoEsquerda = esquerda.calcula();
		return resultadoEsquerda - resultadoDireita;
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaSubtracao(this);
	}

	public Expressao getDireira() {
		return direira;
	}

	public Expressao getEsquerda() {
		return esquerda;
	}

}
