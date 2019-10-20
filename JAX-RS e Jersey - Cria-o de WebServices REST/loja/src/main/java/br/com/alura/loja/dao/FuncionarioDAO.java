package br.com.alura.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.alura.loja.modelo.Funcionario;

public class FuncionarioDAO {

	private static Map<Long, Funcionario> banco = new HashMap<Long, Funcionario>();
	private static AtomicLong contador = new AtomicLong(1);
	
	static{
		banco.put(1l, new Funcionario(1l, "Barry Allen", 23));
		banco.put(2l, new Funcionario(2l, "Iris West", 21));
		banco.put(3l, new Funcionario(3l, "Oliver Queen", 30));
	}
	
	public void adiciona(Funcionario funcionario){
		long id = contador.incrementAndGet();
		funcionario.setId(id);
		banco.put(id, funcionario);
	}
	
	public Funcionario busca(long id){
		return banco.get(id);
	}
	
	public Funcionario remove(long id){
		return banco.remove(id);
	}
	
}
