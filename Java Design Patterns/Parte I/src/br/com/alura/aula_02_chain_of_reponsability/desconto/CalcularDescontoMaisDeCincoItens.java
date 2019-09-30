package br.com.alura.aula_02_chain_of_reponsability.desconto;

import br.com.alura.aula_02_chain_of_reponsability.models.Orcamento;

public class CalcularDescontoMaisDeCincoItens implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}

}
