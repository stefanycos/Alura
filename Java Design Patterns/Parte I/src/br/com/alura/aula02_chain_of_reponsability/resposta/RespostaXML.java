package br.com.alura.aula02_chain_of_reponsability.resposta;

import br.com.alura.aula01_strategy.models.Conta;
import br.com.alura.aula02_chain_of_reponsability.models.Formato;
import br.com.alura.aula02_chain_of_reponsability.models.Requisicao;

public class RespostaXML implements Resposta {

	private Resposta resposta;

	public RespostaXML(Resposta resposta) {
		this.resposta = resposta;
	}

	@Override
	public void reponde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(Formato.XML)) {
			String contaXML = String.format("<conta><titular>%s</titular><saldo>%s</saldo></conta>", conta.getTitular(),
					conta.getSaldo());
			System.out.println(contaXML);
		} else {
			this.resposta.reponde(requisicao, conta);
		}
	}

}
