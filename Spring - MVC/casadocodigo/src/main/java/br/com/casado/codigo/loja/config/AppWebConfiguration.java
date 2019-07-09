package br.com.casado.codigo.loja.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casado.codigo.loja.controllers.HomeController;
import br.com.casado.codigo.loja.dao.ProdutoDAO;
import br.com.casado.codigo.loja.infra.FileSaver;
import br.com.casado.codigo.loja.models.CarrinhoCompras;

/**
 * @author Stefany Souza
 *
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class })
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

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
		
		//disponibiliza os beans como atributos nas paginas .jsp
		resolver.setExposedContextBeanNames("carrinhoCompras");
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");

		// tempo para recarregar o arquivo de properties [messages.properties], caso
		// ocorra alguma alteração no mesmo.
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

	/**
	 * Configuração: registra o pattern para os campos tipo Date ou Calendar, assim
	 * não é necessario especificar o pattern toda vez que utilizarmos
	 * o @DateTimeFormat
	 * 
	 */
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);

		return conversionService;
	}

	/**
	 * Configuração: resolvedor de arquivos de multiplos formatos
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	/*
	 * o Spring MVC por padrão nega acesso a pasta resource, para liberar o acesso
	 * sobrescremos o método abaixo que herdamos de WebMvcConfigurerAdapter
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean //para que o Srping possa gerenciar o restTemplate, utilizado na classe PagamantoController
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
