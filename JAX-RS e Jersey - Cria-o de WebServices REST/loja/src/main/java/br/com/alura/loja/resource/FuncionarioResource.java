package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.FuncionarioDAO;
import br.com.alura.loja.modelo.Funcionario;

@Path("/funcionarios")
public class FuncionarioResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String search(){
		Funcionario funcionario = new FuncionarioDAO().busca(1l);
		return funcionario.toXML();
	}
	
}


