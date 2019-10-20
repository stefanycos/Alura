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

import br.com.alura.loja.modelo.Funcionario;

public class EmployeeTest {
	
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
	public void testaConexaoComServidor(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/funcionarios").request().get(String .class);
		
		Assert.assertTrue(conteudo.contains("<nome>Barry Allen"));
	}
	
	@Test
	public void testaRetornoFuncionarioEsperado(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/funcionarios").request().get(String.class);
		
		Funcionario funcionario = (Funcionario) new XStream().fromXML(conteudo);
		Assert.assertEquals("Barry Allen", funcionario.getNome());
	}

}
