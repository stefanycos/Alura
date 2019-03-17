package br.com.alura.exercicios_extras;

import java.util.HashMap;
import java.util.Map;

public class TestaMap {

	public static void main(String[] args) {

		Map<Integer, String> pessoas = new HashMap<>();
		pessoas.put(21, "Leonardo Cordeiro");
		pessoas.put(27, "Fabio Pimentel");
		pessoas.put(19, "Silvio Mattos");
		pessoas.put(23, "Romulo Henrique");
		
		printValoresMap(pessoas);

	}

	public static void printValoresMap(Map<Integer, String> pessoas) {
		pessoas.keySet().forEach(idade -> {
			System.out.println(idade);
		});
	}
}
