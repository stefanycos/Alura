package br.com.alura.exercicios_extras.aula_8;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TesteFuncionario {

	public static void main(String[] args) {

		Funcionario f1 = new Funcionario("Teste 1", 23);
		Funcionario f2 = new Funcionario("Teste 2", 17);
		Funcionario f3 = new Funcionario("Teste 3", 34);

		Set<Funcionario> funcionarios = new TreeSet<>(new OrdenaPorIdade());
		funcionarios.add(f1);
		funcionarios.add(f2);
		funcionarios.add(f3);

		Iterator<Funcionario> iterator = funcionarios.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getNome());
		}

	}

}
