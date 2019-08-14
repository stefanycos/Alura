package br.com.alura.aula02_chain_of_reponsability.desconto;

import br.com.alura.aula02_chain_of_reponsability.models.Orcamento;

public class SemDesconto implements Desconto{

	
	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto desconto) {
		
	}

}
