package br.com.casado.codigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stefany Souza
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		System.out.println("Exibindo página home da CDC");
		return "home";
	}

}
