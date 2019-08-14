package br.com.alura.aula_03_template_method.impostos;

import br.com.alura.aula_03_template_method.models.Orcamento;

public class ImpostoIKCV extends ImpostoTemplate {

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() >= 500;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}
}
