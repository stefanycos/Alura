package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

@Path("/carrinhos") //The @Path indicates witch URI will access this resource (can be used /carrinhos or carrinhos) 
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Carrinho search(){
		Carrinho carrinho = new CarrinhoDAO().busca(1l);
		return carrinho;
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Carrinho search(@PathParam("id") long id){
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho;
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String searchJson(@PathParam("id") long id){
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho.toJson();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(String conteudo){
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		
		//Setting the address where the resource is being created
		URI uri = URI.create("/carrinhos/" + carrinho.getId());
		
		//Returning the status code 201
		return Response.created(uri).build();
	}
	
	@Path("{id}/produtos/{produtoId}")
	@DELETE
	public Response remove(@PathParam("id") long id, @PathParam("produtoId") long produtoId){
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		carrinho.remove(produtoId);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}/quantidade")
	@PUT
	public Response alteraProduto(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId){
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(conteudo);
		carrinho.trocaQuantidade(produto);
		return Response.ok().build();
	}

}
