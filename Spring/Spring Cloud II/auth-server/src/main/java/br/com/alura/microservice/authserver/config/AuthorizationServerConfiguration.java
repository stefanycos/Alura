package br.com.alura.microservice.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override // usado para fazer a autenticação da aplicação, cria um usuário em memoria
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception { //@formatter:off
		clients.inMemory()
			   .withClient("store") // passado atraves da autorização
			   .secret(passwordEncoder.encode("admin")) // passado atraves da autorização
			   .authorizedGrantTypes("password") // passado atraves do body
			   .scopes("web", "mobile"); // passado atraves do body
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception { 
		endpoints.authenticationManager(authenticationManager)
				 .userDetailsService(userDetailsService); //@formatter:on
	}

}
