package br.com.alura.aula_01_strategy.impostos;

import br.com.alura.aula_01_strategy.models.Orcamento;

public interface Imposto {

	double calculaImposto(Orcamento orcamento);

}
