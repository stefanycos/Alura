package br.com.alura.aula_tres;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.aula_dois.Aula;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	@Override
	public String toString() {
		return "Curso [nome: " + nome + " | Instrutor:" + instrutor + " | Tempo total: "+ this.getTempoTotal() +" | Aulas: " + aulas + "]";
	}
	
	

}
