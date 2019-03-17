package br.com.caelum.camel.commom;

import br.com.caelum.camel.class_1.FileRouteBuilder;
import br.com.caelum.camel.class_2.FileRouteBuilderWithSplitAndFilter;

public class Main {

	private static Context contexto;

	public static void main(String[] args) throws Exception {
		// routeFileRoutBuilder();
		routeWithSplitAndFilter();
	}

	public static void routeFileRoutBuilder() throws Exception {
		contexto = new Context(new FileRouteBuilder());
		contexto.criaContexto();
		contexto.getContext().start();
		sleep();
		contexto.getContext().stop();
	}

	public static void routeWithSplitAndFilter() throws Exception {
		contexto = new Context(new FileRouteBuilderWithSplitAndFilter());
		contexto.criaContexto();
		contexto.getContext().start();
		sleep();
		contexto.getContext().stop();
	}

	private static void sleep() throws Exception {
		Thread.sleep(10000);
	}
}
