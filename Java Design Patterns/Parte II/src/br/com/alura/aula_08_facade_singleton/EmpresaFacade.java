package br.com.alura.aula_08_facade_singleton;

import br.com.alura.aula_08_facade_singleton.dao.ClienteDao;
import br.com.alura.aula_08_facade_singleton.models.Cliente;
import br.com.alura.aula_08_facade_singleton.models.Cobranca;
import br.com.alura.aula_08_facade_singleton.models.ContatoCliente;
import br.com.alura.aula_08_facade_singleton.models.Fatura;
import br.com.alura.aula_08_facade_singleton.models.Tipo;

public class EmpresaFacade {
	
	protected EmpresaFacade(){}
	
	public Cliente buscaCliente(String cpf){
		Cliente cliente = new ClienteDao().buscaPorCpf(cpf);
	}
	
	public Fatura criaFatura(Cliente cliente, double valor){
		Fatura fatura = new Fatura(cliente,valor);
		return fatura;
	}
	
	public Cobranca geraCobranca(Fatura fatura){
		Cobranca cobranca = new Cobranca(Tipo.BOLETO, fatura);
		cobranca.emite();
		
		return cobranca;
	}
	
	public ContatoCliente fazContato(Cliente cliente, Cobranca cobranca){
		ContatoCliente contato = new ContatoCliente(cliente,cobranca);
		contato.dispara();
		
		return contato;
	}
}
