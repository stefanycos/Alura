package br.com.alura.aula_seis;

import br.com.alura.aula_dois.Aula;
import br.com.alura.aula_tres.Curso;

public class TestingCursoAluno {
	
	public static void main(String[] args) {
		Curso curso = new Curso("Dominado coleções do Java", "Paulo Silvera");
		curso.adiciona(new Aula("Trabalahndo com ArrayList", 23));
		curso.adiciona(new Aula("Criando classe Aula", 11));
		curso.adiciona(new Aula("Modelando com coleções", 34));
		
		Aluno a1 = new Aluno("Barry Allen", 1);
		Aluno a2 = new Aluno("Oliver Queen", 2);
		Aluno a3 = new Aluno("Iris West", 3);
		
		curso.matricula(a1);
		curso.matricula(a2);
		curso.matricula(a3);
		
		curso.getAlunos().forEach(aluno -> System.out.println(aluno));
		
	}

}
