package br.com.caelum.camel.class_3;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Connecting to HTTP endpoint using GET method and adding properties.
 *
 */
public class FileRouteBuilderToHttpGet extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:pedidos?noop=true")
			.setProperty("pedidoId", xpath("/pedido/id/text()"))
			.setProperty("clienteId", xpath("/pedido/pagamento/email-titular/text()"))
			.split()
				.xpath(Constants.XPATH_SPLIT_PEDIDO)
				.log(Constants.LOG_BODY)
			.filter()
				.xpath(Constants.XPATH_FILTER_PEDIDO)
			.setProperty("ebookId", xpath("/item/livro/codigo/text()"))
			.marshal()
				.xmljson()
			.setHeader(Exchange.HTTP_QUERY, 
			            simple("clienteId=${property.clienteId}&pedidoId=${property.pedidoId}&ebookId=${property.ebookId}"))
			.setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
		.to(Constants.ITEM_URL);
	}

}
