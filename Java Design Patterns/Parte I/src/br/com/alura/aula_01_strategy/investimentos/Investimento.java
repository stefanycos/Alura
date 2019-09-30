package br.com.alura.aula_01_strategy.investimentos;

import br.com.alura.aula_01_strategy.models.Conta;

public interface Investimento {
	
	double calculaImposto(Conta conta);

}
