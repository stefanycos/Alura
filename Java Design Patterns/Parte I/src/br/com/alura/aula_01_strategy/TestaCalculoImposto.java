package br.com.alura.aula_01_strategy;

import br.com.alura.aula_01_strategy.impostos.ImposotICMS;
import br.com.alura.aula_01_strategy.impostos.Imposto;
import br.com.alura.aula_01_strategy.impostos.ImpostoICCC;
import br.com.alura.aula_01_strategy.impostos.ImpostoISS;
import br.com.alura.aula_01_strategy.models.Orcamento;

public class TestaCalculoImposto {

	public static void main(String[] args) {
		Imposto icms = new ImposotICMS();
		Imposto iss = new ImpostoISS();
		Imposto icc = new ImpostoICCC();
		
		Orcamento orcamento = new Orcamento(999);
		
		// Tamb�m poderiamos remover a classe CalculadoraDeImpostos e chamar o m�todo calcula diretamente
		// a n�o ser que tenhamos alguma regra de neg�cio na classe CalculadoraDeImpostos, tudo depende do context.
		CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
		calculadoraDeImpostos.calcula(icms, orcamento);
		calculadoraDeImpostos.calcula(iss, orcamento);
		calculadoraDeImpostos.calcula(icc, orcamento);
	}
}
