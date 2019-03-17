package br.com.alura.aula_1;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author stefany.o.souza
 * Description: Verificando principios basicos de um arrayList.
 */
public class TestingLista {

	public static void main(String[] args) {
		String aula1 = "Trabalhando com ArrayList.";
		String aula2 = "Preparando o ambiente.";

		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);

		usandoForEach(aulas);
		Collections.sort(aulas);
		usandoForEach(aulas);
	}
	
	
	/**
	 * @param list
	 * Usando o foreach de uma lista
	 */
	public static void usandoForEach(ArrayList<String> aulas) {
		aulas.forEach(classe -> {
			System.out.println("Obetendo aulas...");
			System.out.println("Aulas: " + classe);
		});
	}

}
