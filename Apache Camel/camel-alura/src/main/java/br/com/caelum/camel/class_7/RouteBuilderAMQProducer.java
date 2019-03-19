package br.com.caelum.camel.class_7;

import org.apache.camel.builder.RouteBuilder;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Sending "pedidos" from activemq.
 *
 */
public class RouteBuilderAMQProducer extends RouteBuilder {

	
	@Override
	public void configure() throws Exception {
		
		from("file:pedidos?noop=true")
			.routeId("route-pedido")
			.log("Sending message to AMQ with body: " + Constants.LOG_BODY)
			.to("activemq:queue:pedidos");
	}

}
