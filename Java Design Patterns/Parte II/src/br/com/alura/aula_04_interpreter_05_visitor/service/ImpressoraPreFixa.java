package br.com.alura.aula_04_interpreter_05_visitor.service;

import br.com.alura.aula_04_interpreter_05_visitor.models.Numero;
import br.com.alura.aula_04_interpreter_05_visitor.models.RaizQuadrada;
import br.com.alura.aula_04_interpreter_05_visitor.models.Soma;
import br.com.alura.aula_04_interpreter_05_visitor.models.Subtracao;
import br.com.alura.aula_04_interpreter_05_visitor.models.Visitor;

public class ImpressoraPreFixa implements Visitor {

	@Override
	public void visitaSoma(Soma soma) {
		System.out.print(" + ");
		System.out.print("(");

		soma.getEsquerda().aceita(this);
		System.out.print(" ");
		soma.getDireira().aceita(this);

		System.out.print(")");
	}

	@Override
	public void visitaSubtracao(Subtracao subtracao) {
		System.out.print(" - ");
		System.out.print("(");

		subtracao.getEsquerda().aceita(this);
		System.out.print(" ");
		subtracao.getDireira().aceita(this);

		System.out.print(")");
	}

	@Override
	public void visitaNumero(Numero numero) {
		System.out.print(numero.getNumero());
	}

	@Override
	public void visitaRaiz(RaizQuadrada raizQuadrada) {
		raizQuadrada.getExpressao().aceita(this);
	}

}
