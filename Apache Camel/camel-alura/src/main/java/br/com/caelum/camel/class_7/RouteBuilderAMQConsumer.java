package br.com.caelum.camel.class_7;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import br.com.caelum.camel.commom.Constants;
import br.com.caelum.camel.commom.InvalidPedidoProcessor;

/**
 * @author Stefany Souza
 * Description: Consuming "pedidos" from activemq.
 *
 */
public class RouteBuilderAMQConsumer extends RouteBuilder {

	@SuppressWarnings("deprecation")
	@Override
	public void configure() throws Exception {
		
		errorHandler(
				deadLetterChannel("activemq:queue:pedidos.DLQ") // send the message to another queue in fail cases.
					.redeliverDelay(1000)
					.onRedelivery(new InvalidPedidoProcessor())
					.maximumRedeliveries(2)
		);
		
		from("activemq:queue:pedidos")
			.routeId("route-pedido")
			.delay(1000)
			.log("Body received from AMQ: " + Constants.LOG_BODY)
			.to("direct:soap");
			
		
		from("direct:soap")
			.routeId("route-soap")
			.to("validator:pedido.xsd")
			.to("xslt:pedido-para-soap.xslt")
			.log("Invoking SOAP with body: " + Constants.LOG_BODY)
			.setHeader(Exchange.CONTENT_TYPE, constant("text/xml"))
			.to(Constants.FINANCEIRO_URL);
		
	}

}
