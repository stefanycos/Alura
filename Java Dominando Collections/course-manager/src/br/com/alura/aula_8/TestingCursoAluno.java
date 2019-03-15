package br.com.alura.aula_8;

import java.util.Iterator;
import java.util.Set;

import br.com.alura.aula_2.Aula;
import br.com.alura.aula_3.Curso;
import br.com.alura.aula_6.Aluno;

/**
 * @author stefany.o.souza 
 * Description: Nessa aula verificamos outros modos de percorrer um Collection do tipo Set
 *
 */
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

		printAlunosIterator(curso);

	}

	public static void printAlunosIterator(Curso curso) {
		Set<Aluno> alunos = curso.getAlunos();
		Iterator<Aluno> iterator = alunos.iterator();
		
		while (iterator.hasNext()) {
			Aluno aluno = iterator.next();
			System.out.println(aluno);
		}
	}

}
