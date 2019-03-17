package br.com.alura.aula_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author stefany.o.souza 
 * Description: trabalhando com ordenação. Implementando e utilizando comparator.
 */
public class TestingListaAula {

	public static void main(String[] args) {
		Aula a1 = new Aula("Trabalhando com ArrayList.", 25);
		Aula a2 = new Aula("Preparando o ambiente.", 30);

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
	 * Ordena aulas utilizando o método comparator da classe Aula.
	 */
	public static void ordenaAulaPorTitulo(ArrayList<Aula> aulas) {
		Collections.sort(aulas);
		System.out.println(aulas);
	}

	/**
	 * @param aulas
	 * Ordena aulas, utilizando comparing do comparator por tempo.
	 */
	public static void ordenaAulaComCollection(ArrayList<Aula> aulas) {
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
	}

	/**
	 * @param aulas
	 * Ordena aulas, utilizando comparing do comparator por tempo.
	 * 
	 */
	public static void ordenaAulaComSort(ArrayList<Aula> aulas) {
		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
	}

}
