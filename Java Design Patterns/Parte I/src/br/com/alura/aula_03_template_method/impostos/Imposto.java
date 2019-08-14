package br.com.alura.aula_03_template_method.impostos;

import br.com.alura.aula_03_template_method.models.Orcamento;

public interface Imposto {

	double calculaImposto(Orcamento orcamento);

}
