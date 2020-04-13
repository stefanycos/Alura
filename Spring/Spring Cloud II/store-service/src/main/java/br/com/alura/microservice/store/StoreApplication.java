package br.com.alura.microservice.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.store.configuration.AuthenticationInterceptor;
import feign.RequestInterceptor;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableResourceServer
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@Bean
	public RequestInterceptor authenticationInterceptor(){
		return new AuthenticationInterceptor();
	}

	@Bean
	@LoadBalanced // adding this annotation it's possible to find clients in Eureka by name
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
