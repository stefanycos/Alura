package br.com.alura.aula_tres;

import br.com.alura.aula_dois.Aula;

/**
 * @author stefany.o.souza D
 * Description: Exemplo de restri��o de acesso a lista (lista imutavel)
 *
 */
public class TestingCurso {

	public static void main(String[] args) {
		Curso curso = new Curso("Dominando as cole��es do Java", "Paulo Silvera");
		curso.adiciona(new Aula("Relacionando Cole��es", 17));

		System.out.println(curso.getAulas());
		adicionaAula(curso);
	}

	
	/**
	 * @param curso
	 * Este m�todo retornar� ERRO, j� que a lista de aulas dentro do curso n�o pode ser manipulada
	 * 
	 */
	public static void adicionaAula(Curso curso) {
		curso.getAulas().add(new Aula("Teste", 13));
	}

}
