package br.com.caelum.camel.extra_exercises.class_3;

import java.text.SimpleDateFormat;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import br.com.caelum.camel.commom.Constants;
import br.com.caelum.camel.extra_exercises.models.Negociacao;

public class NegociacaoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Negociacao negociacao = exchange.getIn().getBody(Negociacao.class);
		exchange.setProperty("preco", negociacao.getPreco());
		exchange.setProperty("quantidade", negociacao.getQuantidade());
		String data = new SimpleDateFormat(Constants.DATE_FORMAT).format(negociacao.getData().getTime());
		exchange.setProperty("data", data);

	}

}
