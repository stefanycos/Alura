package br.com.alura.aula_02_chain_of_reponsability.desconto;

import br.com.alura.aula_02_chain_of_reponsability.models.Orcamento;

public class CalcularDescontoMaisDeQuinhentosReais implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		if (orcamento.getValor() > 500) {
			return orcamento.getValor() * 0.07;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}

}
