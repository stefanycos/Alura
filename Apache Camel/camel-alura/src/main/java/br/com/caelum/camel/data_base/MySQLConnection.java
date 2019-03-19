package br.com.caelum.camel.data_base;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class MySQLConnection {

	private MysqlConnectionPoolDataSource poolDataSource;

	public MysqlConnectionPoolDataSource getPoolDataSource() {
		if (poolDataSource == null) {
			createDataSource();
		}
		return poolDataSource;
	}

	/**
	 * Define the data for connection.
	 */
	private void createDataSource() {
		poolDataSource = new MysqlConnectionPoolDataSource();
		poolDataSource.setDatabaseName("camel");
		poolDataSource.setServerName("localhost");
		poolDataSource.setPort(3306);
		poolDataSource.setUser("root");
		poolDataSource.setPassword("root");
	}

}
