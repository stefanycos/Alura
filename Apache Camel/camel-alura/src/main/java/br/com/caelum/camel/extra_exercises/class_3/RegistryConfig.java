package br.com.caelum.camel.extra_exercises.class_3;

import org.apache.camel.impl.SimpleRegistry;

import br.com.caelum.camel.data_base.MySQLConnection;

public class RegistryConfig {

	private static final MySQLConnection CONNECTION = new MySQLConnection();
	private SimpleRegistry registry = new SimpleRegistry();

	public RegistryConfig() {
		addDataSouceInRegistry();
	}

	private void addDataSouceInRegistry() {
		registry.put("mysql", CONNECTION.getPoolDataSource());
	}

	public SimpleRegistry getRegistry() {
		return registry;
	}

}
