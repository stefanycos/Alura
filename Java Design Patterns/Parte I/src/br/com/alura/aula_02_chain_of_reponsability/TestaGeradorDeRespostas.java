package br.com.alura.aula_02_chain_of_reponsability;

import br.com.alura.aula_01_strategy.models.Conta;
import br.com.alura.aula_02_chain_of_reponsability.models.Formato;
import br.com.alura.aula_02_chain_of_reponsability.models.Requisicao;

public class TestaGeradorDeRespostas {
	
	public static void main(String[] args) {
		Conta conta = new Conta("Marina Olvieira", 230.00);
		
		Requisicao requisicao = new Requisicao(Formato.XML);
		
		GeradorDeRepostas repostas = new GeradorDeRepostas();
		repostas.repostaRequisicao(requisicao, conta);
	}

}
