package br.com.alura.aula_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.aula_2.Aula;
import br.com.alura.aula_3.Curso;

/**
 * @author stefany.o.souza
 * Description: Ordenando uma lista imutavel.
 *
 */
public class TestingCurso {

	public static void main(String[] args) {
		Curso curso = new Curso("Dominando as coleções do Java", "Paulo Silvera");
		curso.adiciona(new Aula("Trabalhando com ArrayList", 17));
		curso.adiciona(new Aula("Criando uma aula", 20));
		curso.adiciona(new Aula("Relacionando Coleções", 13));

		System.out.println(curso.getAulas());
		ordenaAulas(curso);
		System.out.println(curso);
	}

	/**
	 * @param curso
	 * Para manipular uma lista imutavel é preciso criar uma cópia da mesma.
	 */
	public static void ordenaAulas(Curso curso) {
		List<Aula> aulasImutaveis = new ArrayList<>(curso.getAulas());
		Collections.sort(aulasImutaveis);
		System.out.println(aulasImutaveis);
	}

}
