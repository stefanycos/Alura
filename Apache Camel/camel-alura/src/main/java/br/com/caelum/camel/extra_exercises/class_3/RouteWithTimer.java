package br.com.caelum.camel.extra_exercises.class_3;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import br.com.caelum.camel.commom.Constants;

/**
 * @author Stefany Souza
 * Description: Here we learned to use the camel component timer.
 *
 */
public class RouteWithTimer extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("timer://negociacoes?fixedRate=true&delay=1s&period=360s")
				.to("http4://argentumws-spring.herokuapp.com/negociacoes")
				.convertBodyTo(String.class) // Converting body received to String, because if not the body can be lost.
				.log("Body Received: " + Constants.LOG_BODY)
				.setHeader(Exchange.FILE_NAME, constant("stock-exchange-business.xml"))
				.to("file:saida");
	}

}
