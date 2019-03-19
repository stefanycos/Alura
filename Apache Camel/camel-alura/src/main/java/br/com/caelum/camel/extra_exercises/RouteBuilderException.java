package br.com.caelum.camel.extra_exercises;

import org.apache.camel.builder.RouteBuilder;
import org.xml.sax.SAXParseException;

/**
 * @author Stefany Souza
 * Description: Testing onException.
 *
 */
public class RouteBuilderException extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		onException(SAXParseException.class)
			.handled(true)
				.to("file:error-parsing");
			
		from("file:pedidos?noop=true")
			.log("file:name")
			.routeId("route-pedido")
			.delay(1000)
			.to("validator:pedido.xsd");
	}

}
