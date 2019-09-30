package br.com.alura.aula_01_strategy.impostos;

import br.com.alura.aula_01_strategy.models.Orcamento;

public class ImposotICMS implements Imposto{

	@Override
	public double calculaImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

}
