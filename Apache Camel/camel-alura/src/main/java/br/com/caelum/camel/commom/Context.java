
package br.com.caelum.camel.commom;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class Context {

	private CamelContext camelContext;
	private RouteBuilder builder;

	public Context(RouteBuilder builder) {
		this.builder = builder;
	}

	public void createContext() throws Exception {
		this.camelContext = new DefaultCamelContext();
		this.camelContext.addRoutes(builder);
	}
	
	public void createContext(SimpleRegistry registry) throws Exception {
		this.camelContext = new DefaultCamelContext(registry);
		this.camelContext.addRoutes(builder);
	}
	
	public void createContextWithAMQ() throws Exception {
		this.camelContext = new DefaultCamelContext();
		this.camelContext.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
		this.camelContext.addRoutes(builder);
	}

	public void startContext() throws Exception {
		this.camelContext.start();
	}

	public void stopContext() throws Exception {
		this.camelContext.stop();
	}

	public CamelContext getCamelContext() {
		return camelContext;
	}

}
