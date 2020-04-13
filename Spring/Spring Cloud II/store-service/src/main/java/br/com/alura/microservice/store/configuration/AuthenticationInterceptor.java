package br.com.alura.microservice.store.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthenticationInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return;
		}

		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
		String token = details.getTokenValue();

		template.header("Authorization", "Bearer " + token);
	}

}
