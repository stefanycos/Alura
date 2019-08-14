package br.com.alura.aula02_chain_of_reponsability;

import br.com.alura.aula02_chain_of_reponsability.desconto.CalculaDescontoPorVendaCasada;
import br.com.alura.aula02_chain_of_reponsability.desconto.CalcularDescontoMaisDeCincoItens;
import br.com.alura.aula02_chain_of_reponsability.desconto.CalcularDescontoMaisDeQuinhentosReais;
import br.com.alura.aula02_chain_of_reponsability.desconto.Desconto;
import br.com.alura.aula02_chain_of_reponsability.desconto.SemDesconto;
import br.com.alura.aula02_chain_of_reponsability.models.Orcamento;

public class CalculadorDeDesconto {
	
	public double calcula(Orcamento orcamento) {
		Desconto d1 = new CalcularDescontoMaisDeCincoItens();
		Desconto d2 = new CalcularDescontoMaisDeQuinhentosReais();
		Desconto d3 = new CalculaDescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		return d1.desconta(orcamento);
	}
}
