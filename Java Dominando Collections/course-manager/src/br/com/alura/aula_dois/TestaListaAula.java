package br.com.alura.aula_dois;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author stefany.o.souza Description: trabalhando com ordena��o. Implementando
 *         e utilizando comparator.
 */
public class TestaListaAula {

	public static void main(String[] args) {
		Aula a1 = new Aula("Working with ArrayList", 25);
		Aula a2 = new Aula("Preparing the environment in all Systems", 30);

		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);

		System.out.println(aulas);
		
		ordenaAulaPorTitulo(aulas);
		ordenaAulaComCollection(aulas);
		ordenaAulaComSort(aulas);

	}
	
	/**
	 * @param aulas
	 * Ordena aulas utilizando o m�todo comparator da classe Aula.
	 */
	public static void ordenaAulaPorTitulo(ArrayList<Aula> aulas) {
		Collections.sort(aulas);
		System.out.println(aulas);
	}

	/**
	 * @param aulas
	 * Ordena aulas utilizando comparing do comparator por tempo
	 */
	public static void ordenaAulaComCollection(ArrayList<Aula> aulas) {
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
	}

	/**
	 * @param aulas
	 * Ordena aulas utilizando comparing do comparator por tempo
	 * 
	 */
	public static void ordenaAulaComSort(ArrayList<Aula> aulas) {
		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
	}

}