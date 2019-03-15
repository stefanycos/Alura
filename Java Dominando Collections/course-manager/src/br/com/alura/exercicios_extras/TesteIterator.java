package br.com.alura.exercicios_extras;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TesteIterator {

	public static void main(String[] args) {

		List<String> letras = new LinkedList<>();
		letras.add("A");
		letras.add("B");
		letras.add("C");
		
		printWithJava8(letras);
		printWithIterator(letras);
	}

	public static void printWithJava8(List<String> letras) {
		letras.forEach(letra -> {
			System.out.println(letra);
		});
	}
	
	public static void printWithIterator(List<String> letras) {
		Iterator<String> iterator = letras.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
