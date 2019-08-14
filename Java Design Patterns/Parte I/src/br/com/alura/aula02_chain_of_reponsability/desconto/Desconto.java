package br.com.alura.aula02_chain_of_reponsability.desconto;

import br.com.alura.aula02_chain_of_reponsability.models.Orcamento;

public interface Desconto {
	
	double desconta(Orcamento orcamento);
	
	void setProximo(Desconto desconto);

}
