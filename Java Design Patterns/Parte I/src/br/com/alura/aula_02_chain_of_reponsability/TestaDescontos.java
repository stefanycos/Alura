package br.com.alura.aula_02_chain_of_reponsability;

import br.com.alura.aula_02_chain_of_reponsability.models.Item;
import br.com.alura.aula_02_chain_of_reponsability.models.Orcamento;

public class TestaDescontos {
	
	public static void main(String[] args) {
		CalculadorDeDesconto desconto = new CalculadorDeDesconto();
		
		Orcamento orcamento = new Orcamento(500);
		orcamento.adicionaItem(new Item("CANETA", 250.0));
		orcamento.adicionaItem(new Item("LAPIS", 250.0));
	
		
		double calcula = desconto.calcula(orcamento);
		System.out.println(calcula);
	}

}
