package br.com.alura.springbootadminmonitoramento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAdminServer
@EnableAutoConfiguration
public class SpringBootAdminMonitoramentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminMonitoramentoApplication.class, args);
	}

}
