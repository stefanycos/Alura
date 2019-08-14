package br.com.alura.aula02_chain_of_reponsability.resposta;

import br.com.alura.aula01_strategy.models.Conta;
import br.com.alura.aula02_chain_of_reponsability.models.Requisicao;

public interface Resposta {
	
	void reponde(Requisicao requisicao, Conta conta);
	
}
