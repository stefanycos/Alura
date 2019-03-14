package br.com.alura.aula_quatro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.aula_dois.Aula;
import br.com.alura.aula_tres.Curso;

/**
 * @author stefany.o.souza
 * Description: Ordenando uma lista imutavel e adicionando método total
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

	public static void ordenaAulas(Curso curso) {
		List<Aula> aulasImutaveis = new ArrayList<>(curso.getAulas());
		Collections.sort(aulasImutaveis);
		System.out.println(aulasImutaveis);
	}

}
