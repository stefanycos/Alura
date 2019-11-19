package br.com.alura.aula_04_interpreter_05_visitor.models;

public interface Visitor {

	void visitaSoma(Soma soma);

	void visitaSubtracao(Subtracao subtracao);

	void visitaNumero(Numero numero);
	
	void visitaRaiz(RaizQuadrada raizQuadrada);

}
