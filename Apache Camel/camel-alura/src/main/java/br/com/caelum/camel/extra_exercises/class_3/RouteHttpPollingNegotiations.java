package br.com.caelum.camel.extra_exercises.class_3;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.camel.commom.Constants;
import br.com.caelum.camel.extra_exercises.models.Negociacao;

/**
 * @author Stefany Souza
 * Description: Using the xStream to unmarshal the response and database sharing pattern to persist XML received.
 */
public class RouteHttpPollingNegotiations extends RouteBuilder {
	
	private static final String INSERT_STATEMENT = "insert into negociacao(preco, quantidade, data) values (${property.preco}, ${property.quantidade}, '${property.data}')";

	@Override
	public void configure() throws Exception {
		XStream xstream = new XStream();
		xstream.alias("negociacao", Negociacao.class);

		from("timer://negociacoes?fixedRate=true&delay=3s&period=360s")
				.to("http4://argentumws.caelum.com.br/negociacoes").convertBodyTo(String.class)
				.unmarshal(new XStreamDataFormat(xstream))
				.split(body())
					.log(Constants.LOG_BODY)
					.process(new NegociacaoProcessor())
				.setBody(simple(INSERT_STATEMENT))
				.log(Constants.LOG_BODY) // print sql command.
				.delay(1000) // wait 1 second to understand better the execution.
				.to("jdbc:mysql"); // using the component jdbc to send the sql commands to MySQL.

	}

}
