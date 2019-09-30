package br.com.alura.aula_02_chain_of_reponsability.resposta;

import br.com.alura.aula_01_strategy.models.Conta;
import br.com.alura.aula_02_chain_of_reponsability.models.Formato;
import br.com.alura.aula_02_chain_of_reponsability.models.Requisicao;

public class RespostaCVS implements Resposta {

	private Resposta reposta;

	public RespostaCVS(Resposta reposta) {
		this.reposta = reposta;
	}
	
	public RespostaCVS() {
		this.reposta = null;
	}

	@Override
	public void reponde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(Formato.CVS)) {
			String contaCVS = conta.getTitular() + ";" + conta.getSaldo();
			System.out.println(contaCVS);
		} else {
			reposta.reponde(requisicao, conta);
		}

	}

}
