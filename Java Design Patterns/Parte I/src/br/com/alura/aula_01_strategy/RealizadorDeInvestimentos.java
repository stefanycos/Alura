package br.com.alura.aula_01_strategy;

import br.com.alura.aula_01_strategy.investimentos.Investimento;
import br.com.alura.aula_01_strategy.models.Conta;

public class RealizadorDeInvestimentos {

	public void realiza(Conta conta, Investimento investimento) {
		double resultado = investimento.calculaImposto(conta);

		conta.depositar(resultado * 0.75);
		System.out.println("Novo saldo: " + conta.getSaldo());
	}

}
