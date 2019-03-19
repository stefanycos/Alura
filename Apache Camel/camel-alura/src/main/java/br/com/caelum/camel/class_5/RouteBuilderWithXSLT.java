package br.com.caelum.camel.class_5;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Transforming the message received with XSLT and integrating with SOAP.
 *
 */
public class RouteBuilderWithXSLT extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:pedidos?noop=true")
			.routeId("route-pedido")
			.multicast()
				.to("direct:http")
				.to("direct:soap");
			
		from("direct:http")
			.routeId("route-http")
			.setProperty("pedidoId", xpath("/pedido/id/text()"))
			.setProperty("clienteId", xpath("/pedido/pagamento/email-titular/text()"))
			.split()
				.xpath(Constants.XPATH_SPLIT_PEDIDO)
			.filter()
				.xpath(Constants.XPATH_FILTER_PEDIDO)
			.setProperty("ebookId", xpath("/item/livro/codigo/text()"))
			.marshal()
				.xmljson()
			.setHeader(Exchange.HTTP_QUERY, 
			            simple("clienteId=${property.clienteId}&pedidoId=${property.pedidoId}&ebookId=${property.ebookId}"))
			.setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
			.to(Constants.ITEM_URL);
		
		from("direct:soap")
			.routeId("route-soap")
			.to("xslt:pedido-para-soap.xslt")
			.log("Body after tranformation: " + Constants.LOG_BODY)
			.setHeader(Exchange.CONTENT_TYPE, constant("text/xml"))
			.to(Constants.FINANCEIRO_URL);
		
	}

}
