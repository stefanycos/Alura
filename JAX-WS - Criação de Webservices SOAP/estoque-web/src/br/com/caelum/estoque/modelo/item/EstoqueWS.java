package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.usuario.AutorizacaoExeption;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style =  Style.DOCUMENT, use = Use.LITERAL, parameterStyle =  ParameterStyle.WRAPPED)
public class EstoqueWS {
	
	private ItemDao dao = new ItemDao();
	
	
	@WebMethod(operationName = "TodosOsItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	@RequestWrapper(localName="listaitens")
	public ListaItens getItens(@WebParam(name="filtros") Filtros filtros){

	        List<Filtro> lista = filtros.getLista();
	        List<Item> result = dao.todosItens(lista);
	        return new ListaItens(result);
	}
	
	@WebMethod(operationName = "CadastrarItem")
	public Item cadastrarItem(@WebParam(name = "token", header = true) TokenUsuario token, 
							  @WebParam(name = "item") Item item) 
									  throws AutorizacaoExeption{
		
		if(!new TokenDao().ehValido(token))
			throw new AutorizacaoExeption("Autorização Falhou");
		
		new ItemValidador(item).validate();
		
		System.out.println("Cadastrando Item: " + item);
		this.dao.cadastrar(item);
		return item;
	}
	
	@Oneway
	@WebMethod(operationName = "GerarRelatorio")
	public void gerarRelatorio(){
		
	}


}
