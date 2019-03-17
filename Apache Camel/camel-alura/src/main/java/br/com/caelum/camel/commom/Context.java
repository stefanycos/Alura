package br.com.caelum.camel.commom;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Context {

	private CamelContext context;
	private RouteBuilder builder;

	public Context(RouteBuilder builder) {
		this.builder = builder;
	}

	public void criaContexto() throws Exception {
		this.context = new DefaultCamelContext();
		this.context.addRoutes(builder);
	}

	public void iniciaContexto() throws Exception {
		this.context.start();
		Thread.sleep(1000);
	}

	public void paraContexto() throws Exception {
		this.context.stop();
	}

	public CamelContext getContext() {
		return context;
	}

}
