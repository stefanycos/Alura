package br.com.alura.aula_5;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author stefany.o.souza
 * Description: utilizando HashSet da Collection e adicionando método getTotal.
 *  *
 */
public class TestingAluno {

	public static void main(String[] args) {

		Collection<String> alunos = new HashSet<>();
		alunos.add("Oliver Queen");
		alunos.add("Barry Alen");
		alunos.add("Kara Denvers");
		alunos.add("Iris West");
		alunos.add("Felicity Smoak");
		
		imprimeAlunos(alunos);
		imprimeTotal(alunos);
		alunos.add("Iris West");
		
		imprimeAlunos(alunos);
		imprimeTotal(alunos);
	}
	
	public static void imprimeTotal(Collection<String> alunos) {
		System.out.println("Total alunos: " + alunos.size());
	}
	
	public static void imprimeAlunos(Collection<String> alunos) {
		alunos.forEach(aluno -> System.out.println(aluno));
	}

}
