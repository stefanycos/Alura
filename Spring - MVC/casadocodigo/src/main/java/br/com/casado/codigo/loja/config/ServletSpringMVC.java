package br.com.casado.codigo.loja.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Stefany Souza
 * Responsável por atender as requisições que chegam na aplicação.
 *
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Retorna um array de classes de configuração. 
	 **/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppWebConfiguration.class, JPAConfiguration.class };
	}

	/**
	 * Retorna um array de mapeamentos que a servlet irá atender.
	 * Nesse caso estamos configurando o ServletMVC para atender requisições a partir da raiz.
	 **/
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		//Quando a requisição chegar no Spring ele vai tranformar para UTF-8
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}
	
	/*
	 * Registro da configuração de multpart
	 * MultipartConfigElement(""): recebe o tipo de separador do arquivo, como esta em branco pegará o nome original
	 * */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}
