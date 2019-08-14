package br.com.alura.aula02_chain_of_reponsability;

import br.com.alura.aula01_strategy.models.Conta;
import br.com.alura.aula02_chain_of_reponsability.models.Requisicao;
import br.com.alura.aula02_chain_of_reponsability.resposta.Resposta;
import br.com.alura.aula02_chain_of_reponsability.resposta.RespostaCVS;
import br.com.alura.aula02_chain_of_reponsability.resposta.RespostaXML;

public class GeradorDeRepostas {
	
	public void repostaRequisicao(Requisicao requisicao, Conta conta) {
		Resposta r2 = new RespostaCVS();
		Resposta r1 = new RespostaXML(r2);
		
		r1.reponde(requisicao, conta);
	}

}
