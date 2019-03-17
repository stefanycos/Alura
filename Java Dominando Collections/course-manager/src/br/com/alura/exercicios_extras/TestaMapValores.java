package br.com.alura.exercicios_extras;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestaMapValores {

	public static void main(String[] args) {
		Map<String, Integer> nomesParaIdade = new HashMap<>();
		nomesParaIdade.put("Paulo", 31);
		nomesParaIdade.put("Adriano", 25);
		nomesParaIdade.put("Alberto", 33);
		nomesParaIdade.put("Guilherme", 26);

		getChaves(nomesParaIdade);
		getValores(nomesParaIdade);
		getAssociacoes(nomesParaIdade);
	}

	public static void getChaves(Map<String, Integer> nomesParaIdade) {
		Set<String> chaves = nomesParaIdade.keySet();
		for (String nome : chaves) {
			System.out.println(nome);
		}
	}

	public static void getValores(Map<String, Integer> nomesParaIdade) {
		Collection<Integer> valores = nomesParaIdade.values();
		for (Integer idade : valores) {
			System.out.println(idade);
		}
	}

	public static void getAssociacoes(Map<String, Integer> nomesParaIdade) {
		Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();
		for(Entry<String, Integer> ass: associacoes){
			System.out.println("Chave: " + ass.getKey() + " | Valor: " + ass.getValue());
		}
	}

}
