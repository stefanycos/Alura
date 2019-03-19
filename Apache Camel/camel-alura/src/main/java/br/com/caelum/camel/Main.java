package br.com.caelum.camel;

import br.com.caelum.camel.class_1.FileRouteBuilder;
import br.com.caelum.camel.class_2.FileRouteBuilderWithSplitAndFilter;
import br.com.caelum.camel.class_3.FileRouteBuilderToHttpGet;
import br.com.caelum.camel.class_3.FileRouteBuilderToHttpPost;
import br.com.caelum.camel.commom.Context;
import br.com.caelum.camel.extra_exercises.class_3.RegistryConfig;
import br.com.caelum.camel.extra_exercises.class_3.RouteHttpPollingNegotiations;
import br.com.caelum.camel.extra_exercises.class_3.RouteWithTimer;

public class Main {

	private static Context context;

	public static void main(String[] args) throws Exception {
		// routeFileRoutBuilder();
		// routeWithSplitAndFilter();
		// routeToHttpGet();
		// usingTimer();
		// pollingNegotiation();
	}

	public static void routeFileRoutBuilder() throws Exception {
		context = new Context(new FileRouteBuilder());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeWithSplitAndFilter() throws Exception {
		context = new Context(new FileRouteBuilderWithSplitAndFilter());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeToHttpPost() throws Exception {
		context = new Context(new FileRouteBuilderToHttpPost());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeToHttpGet() throws Exception {
		context = new Context(new FileRouteBuilderToHttpGet());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void usingTimer() throws Exception {
		context = new Context(new RouteWithTimer());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void pollingNegotiation() throws Exception {
		context = new Context(new RouteHttpPollingNegotiations());
		context.createContext(new RegistryConfig().getRegistry());
		context.startContext();
		sleep();
		context.stopContext();
	}

	private static void sleep() throws Exception {
		Thread.sleep(10000);
	}
}
