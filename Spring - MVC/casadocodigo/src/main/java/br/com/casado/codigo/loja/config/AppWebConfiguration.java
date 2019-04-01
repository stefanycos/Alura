package br.com.casado.codigo.loja.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casado.codigo.loja.controllers.HomeController;
import br.com.casado.codigo.loja.dao.ProdutoDAO;

/**
 * @author Stefany Souza
 *
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDAO.class })
public class AppWebConfiguration {

	/**
	 * @return setPrefix: define a localização das views setSuffix: define a
	 *         extensão das views
	 * 
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");

		// tempo para recarregar o arquivo de properties [messages.properties], caso ocorra alguma alteração no mesmo.
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

}
