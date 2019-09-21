package br.com.alura.aula_04_decorator;

import br.com.alura.aula_04_decorator.impostos.Imposto;
import br.com.alura.aula_04_decorator.impostos.ImpostoICMS;
import br.com.alura.aula_04_decorator.impostos.ImpostoISS;
import br.com.alura.aula_04_decorator.impostos.ImpostoMuitoAlto;
import br.com.alura.aula_04_decorator.models.Orcamento;

public class TestaImpostoComposto {

	public static void main(String[] args) {

		Imposto iss = new ImpostoISS(new ImpostoICMS());
		Imposto icms = new ImpostoICMS(new ImpostoMuitoAlto(new ImpostoISS()));
		
		Orcamento orcamento = new Orcamento(500);

		double valor = iss.calcula(orcamento);
		double valorICMS = icms.calcula(orcamento);
		
		System.out.println(valor);
		System.out.println(valorICMS);
	}
}
