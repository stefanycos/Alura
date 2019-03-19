package br.com.caelum.camel.class_3;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Connecting to HTTP endpoint using POST method.
 *
 */
public class FileRouteBuilderToHttpPost extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:pedidos?noop=true").
			split().
				xpath(Constants.XPATH_SPLIT_PEDIDO).
				log(Constants.LOG_BODY).
			filter().
				xpath(Constants.XPATH_FILTER_PEDIDO).
			marshal().
				xmljson().
				log(Constants.LOG_BODY).
			setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST)).
		to(Constants.ITEM_URL);
	}

}
