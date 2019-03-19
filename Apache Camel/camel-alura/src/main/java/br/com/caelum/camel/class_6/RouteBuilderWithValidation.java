package br.com.caelum.camel.class_6;

import org.apache.camel.builder.RouteBuilder;

import br.com.caelum.camel.commom.InvalidPedidoProcessor;

/**
 * @author Stefany Souza
 * Description: Adding validation and error handling.
 *
 */
public class RouteBuilderWithValidation extends RouteBuilder {

	@SuppressWarnings("deprecation")
	@Override
	public void configure() throws Exception {
		
		errorHandler(
				deadLetterChannel("file:erro")
					.maximumRedeliveries(3)
					.redeliverDelay(5000)
					.onRedelivery(new InvalidPedidoProcessor())
		);
		
		from("file:pedidos?noop=true")
			.log("file:name")
			.routeId("route-pedido")
			.delay(1000)
			.to("validator:pedido.xsd");
	}

}
