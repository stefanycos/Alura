package br.com.alura.aula_02_chain_of_reponsability.desconto;

import br.com.alura.aula_02_chain_of_reponsability.models.Item;
import br.com.alura.aula_02_chain_of_reponsability.models.Orcamento;

public class CalculaDescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		
		if (temVendaCasada(orcamento)) {
			return orcamento.getValor() * 0.5;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}
	
	private boolean temVendaCasada(Orcamento orcamento) {
		return existeItem("LAPIS", orcamento) && existeItem("CANETA", orcamento);
	}

	private boolean existeItem(String nomeItem, Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getNome().equalsIgnoreCase("LAPIS")) {
				return true;
			}
		}

		return false;
	}

}
