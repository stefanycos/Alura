package br.com.alura.aula_01_strategy.impostos;

import br.com.alura.aula_01_strategy.models.Orcamento;

public class ImpostoICCC implements Imposto {

	public double calculaImposto(Orcamento orcamento) {
		if (orcamento.getValor() < 1000) {
			return orcamento.getValor() * 0.05;
		} else if (orcamento.getValor() <= 3000) {
			return orcamento.getValor() * 0.07;
		} else {
			return orcamento.getValor() * 0.08 + 30;
		}
	}

}
