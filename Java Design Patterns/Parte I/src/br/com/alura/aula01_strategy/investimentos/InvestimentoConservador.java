package br.com.alura.aula01_strategy.investimentos;

import br.com.alura.aula01_strategy.models.Conta;

public class InvestimentoConservador implements Investimento{

	@Override
	public double calculaImposto(Conta conta) {
		return conta.getSaldo() * 0.008;
	}

}
