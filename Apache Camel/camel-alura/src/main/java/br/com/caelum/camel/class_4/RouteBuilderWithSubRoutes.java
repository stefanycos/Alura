package br.com.caelum.camel.class_4;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Working with sub routes, mock and multicast.
 *
 */
public class RouteBuilderWithSubRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:pedidos?noop=true")
			.routeId("route-pedido")
			.multicast() // The multicast is used to delivery the same message for both routes, if it's not setted the message received will be the response gave by the last route invoked.
				//.parallelProcessing() Process the two routes in parallel.
					.to("direct:http")
					.to("direct:soap");
			
		from("direct:http")
			.routeId("route-http")
			.log("HTTP Route being executed...")
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
		
		from("direct:soap")
			.routeId("route-soap")
			.log("Soap Route being executed...")
			.to("mock:soap");
		
	}

}
