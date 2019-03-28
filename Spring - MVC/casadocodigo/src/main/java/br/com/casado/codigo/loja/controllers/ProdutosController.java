package br.com.casado.codigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casado.codigo.loja.dao.ProdutoDAO;
import br.com.casado.codigo.loja.models.Produto;

@Controller
public class ProdutosController {
	
	
	@Autowired // delega ao Spring o controle do objeto, indica que esse objeto é um Bean do Srping e precisamos que ele nos dê uma instancia pode meia da injeção de dependencia
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto.toString());
		produtoDAO.gravar(produto);
		return "produtos/ok";
	}

}
