package br.com.alura.aula_01_strategy;

import br.com.alura.aula_01_strategy.impostos.Imposto;
import br.com.alura.aula_01_strategy.models.Orcamento;

public class CalculadoraDeImpostos {
	
	public void calcula(Imposto imposto, Orcamento orcamento) {
		double calculaImposto = imposto.calculaImposto(orcamento);
		System.out.println("Valor imposto: " + calculaImposto);
	}

}
