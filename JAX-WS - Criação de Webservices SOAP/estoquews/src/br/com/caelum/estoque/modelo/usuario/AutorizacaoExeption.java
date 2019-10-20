package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault", messageName = "AutorizacaoFault")
public class AutorizacaoExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizacaoExeption(String mensagem) {
		super(mensagem);
	}
	
	public InfoFault getFaultInfo(){
		return new InfoFault("Token Invalido", new Date());
	}
	
}
