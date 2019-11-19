package br.com.alura.aula_04_interpreter_05_visitor.models;

public class RaizQuadrada implements Expressao {

	private Expressao expressao;

	public RaizQuadrada(Expressao expressao) {
		this.expressao = expressao;
	}

	@Override
	public int calcula() {
		return (int) Math.sqrt(expressao.calcula());
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaRaiz(this);
	}

	public Expressao getExpressao() {
		return expressao;
	}

}
