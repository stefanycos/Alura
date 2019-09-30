package br.com.alura.aula_01_strategy.investimentos;

import java.util.Random;

import br.com.alura.aula_01_strategy.models.Conta;

public class InvestimentoArrojado implements Investimento {

	private Random random;

	public InvestimentoArrojado() {
		this.random = new Random();
	}

	public double calculaImposto(Conta conta) {
		int chute = random.nextInt(10);

		if (chute >= 0 && chute <= 1) {
			return conta.getSaldo() * 0.05;
		} else if (chute >= 2 && chute <= 4) {
			return conta.getSaldo() * 0.03;
		} else {
			return conta.getSaldo() * 0.006;
		}
	}
}
