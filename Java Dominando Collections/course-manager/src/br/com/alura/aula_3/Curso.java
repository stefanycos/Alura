package br.com.alura.aula_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import br.com.alura.aula_2.Aula;
import br.com.alura.aula_6.Aluno;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Aluno> alunosMatriculados = new HashMap<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.alunosMatriculados.put(aluno.getNumeroMatricula(), aluno);
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

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean alunoEstaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaAlunoMatriculado(Integer numeroMatricula) {
		if (!this.alunosMatriculados.containsKey(numeroMatricula)) {
			throw new NoSuchElementException("Aluno com matricula: " + numeroMatricula + " não encontrado.");
		}
		return this.alunosMatriculados.get(numeroMatricula);
	}

	@Override
	public String toString() {
		return "Curso [nome: " + nome + " | Instrutor:" + instrutor + " | Tempo total: " + this.getTempoTotal()
				+ " | Aulas: " + aulas + "]";
	}

}
