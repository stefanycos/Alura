package br.com.alura.aula_01_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		try {
			
			String bankType = System.getenv("bankType");
			
			if (bankType.equals("mysql")) {
				return DriverManager
						.getConnection("jdbc:mysql://localhost:3306/banco", "usuario", "senha"); // NOSONAR
			}
			
			return DriverManager
					.getConnection("jdbc:postgres://localhost:3306/banco", "usuario", "senha"); // NOSONAR

		} catch (SQLException e) {
			throw new RuntimeException(); // NOSONAR
		}
	}

}
