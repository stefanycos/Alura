package br.com.alura.exercicios_extras;


import java.util.Collections;
import java.util.Set;

/**
 * @author stefany.o.souza
 *
 */
public class TestaEmptySet {

	public static void main(String[] args) {
		/*
		 * As linhas de códico abaixo retorna uma exeception java.lang.UnsupportedOperationException
		 * já que o conjunto foi settado como empty, nenhum elemento pode ser inserido no mesmo.
		 * Isso pode ser util em alguns casos.
		 * 
		 */
		
		Set<String> nomes = Collections.emptySet();
		nomes.add("Barry");
	}
}
