package br.com.caelum.aula_03;

public class Teste {
	public static void main(String[] args) {
		TabelaDePreco tabela = new TabelaDePrecoDiferenciada();
		ServicoDeEntrega entrega = new Frete();
		new CalculadoraDePrecos(tabela, entrega);
	}
}
