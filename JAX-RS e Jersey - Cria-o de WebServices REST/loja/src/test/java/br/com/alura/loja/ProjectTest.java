package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Projeto;

public class ProjectTest {
	
	private HttpServer server;
	
	@Before
	public void startaServidor(){
		server = Servidor.inicializaServidor();
	}
	
	@After
	public void mataServidor(){
		server.stop();
	}
	
	@Test
	public void testaConexaoComMeuServidor(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha Loja</nome>"));
	}
	
	@Test
	public void testaRetornoProjetoEsperado(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);
		
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		Assert.assertEquals("Minha Loja", projeto.getNome());
	}

}
