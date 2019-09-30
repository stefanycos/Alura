package br.com.alura.aula_05_state;

import br.com.alura.aula_05_state.states.Orcamento;

public class TestaDescontoExtra {
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(500.00);
		
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		orcamento.aprova();
		
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		orcamento.finaliza();
		
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		orcamento.aprova(); // Erro pois já foi finalizado
	}

}
