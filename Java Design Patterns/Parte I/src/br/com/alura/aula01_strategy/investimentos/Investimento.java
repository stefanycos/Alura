package br.com.alura.aula01_strategy.investimentos;

import br.com.alura.aula01_strategy.models.Conta;

public interface Investimento {
	
	double calculaImposto(Conta conta);

}
