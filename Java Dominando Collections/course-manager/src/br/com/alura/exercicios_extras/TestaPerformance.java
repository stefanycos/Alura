package br.com.alura.exercicios_extras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		tempoArrayList();
		tempoHashSet();
	}

	public static void tempoArrayList() {
		Collection<Integer> numeros = new ArrayList<>();

		long inicio = System.currentTimeMillis();

		for (int i = 1; i <= 50000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto utilizando ArrayList: " + tempoDeExecucao);
	}

	public static void tempoHashSet() {
		Collection<Integer> numeros = new HashSet();
		long inicio = System.currentTimeMillis();

		for (int i = 1; i <= 50000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}
		
		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto utilizando HashSet: " + tempoDeExecucao);
	}

}
