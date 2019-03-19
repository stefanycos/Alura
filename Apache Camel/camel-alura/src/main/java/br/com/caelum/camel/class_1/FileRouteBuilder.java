
package br.com.caelum.camel.class_1;

import org.apache.camel.builder.RouteBuilder;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Defining the first route for files using the pattern: file sharing.
 * 
 */
public class FileRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:pedidos?noop=true")
			.log("${exchange.pattern}")
			.log(Constants.LOG_BODY)
			.marshal()
				.xmljson()
			.log(Constants.LOG_ID)
			.log(Constants.LOG_BODY)
			.setHeader("CamelFileName", simple("${file:name.noext}.json"))
		.to("file:saida");
	}

}

