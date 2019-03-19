package br.com.caelum.camel.commom;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InvalidPedidoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		int counter = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_COUNTER);
		int max = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_MAX_COUNTER);
		System.out.println("Retrying to delivery [pedido]. Attempt: " + counter + "/" + max);
	}

}
