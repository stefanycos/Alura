package br.com.casado.codigo.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casado.codigo.loja.controllers.HomeController;
import br.com.casado.codigo.loja.dao.ProdutoDAO;

/**
 * @author stefany.o.souza
 * @ComponentScan - Configura o caminho (pacote) onde os controllers estão, podemos passar um array de Strings com os nomes dos pacotes
 * ou um aaray de classes, passar a classe é melhor, pois o SpringMVC pega os pacotes automaticamente a partir das classes,
 * se colocassemos String e houvesse alguma alteração no nome do pacote, teriamos que lembrar de alterar aqui também.
 */
@EnableWebMvc
@ComponentScan(basePackageClasses= {HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {

	/**
	 * @return
	 * 
	 * (setPrefix) - Define a localização das views
	 * (setSuffix) - Define a extensão das views
	 * @Bean transforma-o em um Bean, assim será gerenciado pelo Spring.
	 * 
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
