package br.com.alura.aula_03_template_method.impostos;

import br.com.alura.aula_03_template_method.models.Orcamento;

public class ImposotICMS implements Imposto{

	@Override
	public double calculaImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

}
