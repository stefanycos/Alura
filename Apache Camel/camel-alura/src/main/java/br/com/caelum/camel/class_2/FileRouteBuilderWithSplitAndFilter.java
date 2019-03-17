package br.com.caelum.camel.class_2;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 * @author Stefany Souza
 * Description: Adding split e filter for received messages.
 *
 */
public class FileRouteBuilderWithSplitAndFilter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:pedidos?noop=true").
			split(). // It's always possible to split like this: split(xpath("/pedido/itens/item")).
				xpath("/pedido/itens/item").
				log("${body}").
			filter(). // It's always possible to filter like this: filter(xpath("/item/formato[text()='EBOOK']")).
				xpath("/item/formato[text() ='EBOOK']").
			marshal().
				xmljson().
				log("${body}").
			/** 
			 * setHeader("CamelFileName", simple("${file:name.noext}.json")).
			 * The line above overwrite the content when a "pedido" come with more than one "item", because it was saved with the same name
			 * In below line we have the solution for this problem
			 *
			 **/	
			setHeader(Exchange.FILE_NAME, simple("${file:name.noext}-${header.CamelSplitIndex}.json")).
		to("file:saida");
	}

}
