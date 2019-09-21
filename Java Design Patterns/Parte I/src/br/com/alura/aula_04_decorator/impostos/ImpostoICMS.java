package br.com.alura.aula_04_decorator.impostos;

import br.com.alura.aula_04_decorator.models.Orcamento;

public class ImpostoICMS extends Imposto {

	public ImpostoICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	public ImpostoICMS() {
	}

	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculoDoOutroImposto(orcamento);
	}

}
