package br.com.caelum.camel;

import br.com.caelum.camel.class_1.FileRouteBuilder;
import br.com.caelum.camel.class_2.FileRouteBuilderWithSplitAndFilter;
import br.com.caelum.camel.class_3.FileRouteBuilderToHttpGet;
import br.com.caelum.camel.class_3.FileRouteBuilderToHttpPost;
import br.com.caelum.camel.class_4.RouteBuilderWithSubRoutes;
import br.com.caelum.camel.class_5.RouteBuilderWithXSLT;
import br.com.caelum.camel.class_6.RouteBuilderWithValidation;
import br.com.caelum.camel.class_7.RouteBuilderAMQConsumer;
import br.com.caelum.camel.class_7.RouteBuilderAMQProducer;
import br.com.caelum.camel.commom.Context;
import br.com.caelum.camel.extra_exercises.RouteBuilderException;
import br.com.caelum.camel.extra_exercises.class_3.RegistryConfig;
import br.com.caelum.camel.extra_exercises.class_3.RouteHttpPollingNegotiations;
import br.com.caelum.camel.extra_exercises.class_3.RouteWithTimer;

public class Main {

	private static Context context;

	public static void main(String[] args) throws Exception {
		//** Discoment one of the lines below to test **/
		
		// routeFileRoutBuilder();
		// routeWithSplitAndFilter();
		// routeToHttpPost();
		// routeToHttpGet();
		// routeWithTimer();
		// routeWithMySQL();
		// routeWithSubRoutes();
		// routeWithXSLT();
		// routeWithValidation();
		// routeWithException();
		// routeAMQConsumer();
		// routeAMQProducer();

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

	public static void routeWithTimer() throws Exception {
		context = new Context(new RouteWithTimer());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeWithMySQL() throws Exception {
		context = new Context(new RouteHttpPollingNegotiations());
		context.createContext(new RegistryConfig().getRegistry());
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeWithSubRoutes() throws Exception {
		context = new Context(new RouteBuilderWithSubRoutes());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeWithXSLT() throws Exception {
		context = new Context(new RouteBuilderWithXSLT());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeWithValidation() throws Exception {
		context = new Context(new RouteBuilderWithValidation());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeWithException() throws Exception {
		context = new Context(new RouteBuilderException());
		context.createContext();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeAMQConsumer() throws Exception {
		context = new Context(new RouteBuilderAMQConsumer());
		context.createContextWithAMQ();
		context.startContext();
		sleep();
		context.stopContext();
	}

	public static void routeAMQProducer() throws Exception {
		context = new Context(new RouteBuilderAMQProducer());
		context.createContextWithAMQ();
		context.startContext();
		sleep();
		context.stopContext();
	}

	private static void sleep() throws Exception {
		Thread.sleep(10000);
	}
}
