package br.com.casado.codigo.loja.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Stefany Souza
 * Responsavel por atender as requisições que chegam na aplicação.
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

}
