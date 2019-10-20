package br.com.alura.loja.modelo;

import com.thoughtworks.xstream.XStream;

public class Funcionario {
	
	private long id;
	private String nome;
	private int idade;
	
	
	public Funcionario(){}
	
	public Funcionario(long id, String nome, int idade){
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getIdade(){
		return this.idade;
	}
	
	public String toXML(){
		return new XStream().toXML(this);
	}

}
