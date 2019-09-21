package br.com.alura.aula_04_decorator.impostos;

import br.com.alura.aula_04_decorator.models.Orcamento;

public class ImpostoISS extends Imposto {

	public ImpostoISS() {
	}

	public ImpostoISS(Imposto outroImposto) {
		super(outroImposto);
	}

	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}

}
