package br.com.alura.aula_01_strategy.investimentos;

import java.util.Random;

import br.com.alura.aula_01_strategy.models.Conta;

public class InvestimentoModerado implements Investimento {

	private Random random;

	public InvestimentoModerado() {
		this.random = new Random();
	}

	@Override
	public double calculaImposto(Conta conta) {
		if (random.nextInt(2) == 0) {
			return conta.getSaldo() * 0.025;
		} else {
			return conta.getSaldo() * 0.007;
		}
	}
}
