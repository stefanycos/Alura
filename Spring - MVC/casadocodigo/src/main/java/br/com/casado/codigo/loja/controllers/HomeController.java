package br.com.casado.codigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stefany Souza
 *
 */
@Controller
public class HomeController {
	
	/**
	 * @return String
	 * Responsavel por atender as requisições que chegam na pagina inicial, o home da aplicação, ou seja, o endereço raiz /.
	 * Retorna o nome da pagina que será exibida, neste caso home.
	 * 
	 * @RequestMapping("/") - define que este método atende a um determinado path, nesse caso o path é ("/")
	 * 
	 */
	@RequestMapping("/")
	public String index() {
		System.out.println("Exibindo página home da CDC");
		return "home";
	}

}
