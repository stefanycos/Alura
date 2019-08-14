package br.com.alura.aula_03_template_method.impostos;

import br.com.alura.aula_03_template_method.models.Orcamento;

public abstract class ImpostoTemplate implements Imposto {

	@Override
	public double calculaImposto(Orcamento orcamento) {
		if (deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	public abstract double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

	public abstract double minimaTaxacao(Orcamento orcamento);

}
