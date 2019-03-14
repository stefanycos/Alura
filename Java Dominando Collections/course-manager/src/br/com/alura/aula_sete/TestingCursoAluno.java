package br.com.alura.aula_sete;

import br.com.alura.aula_dois.Aula;
import br.com.alura.aula_seis.Aluno;
import br.com.alura.aula_tres.Curso;

/**
 * @author stefany.o.souza
 * Description: Nessa aula validamos a importancia do método equals e hashCode para uma Collection do tipo Set.
 *
 */
public class TestingCursoAluno {

	public static void main(String[] args) {
		Curso curso = new Curso("Dominado coleções do Java", "Paulo Silvera");
		curso.adiciona(new Aula("Trabalahndo com ArrayList", 23));
		curso.adiciona(new Aula("Criando classe Aula", 11));
		curso.adiciona(new Aula("Modelando com coleções", 34));

		Aluno a1 = new Aluno("Barry Allen", 1);
		Aluno a2 = new Aluno("Oliver Queen", 2);
		Aluno a3 = new Aluno("Iris West", 3);

		curso.matricula(a1);
		curso.matricula(a2);
		curso.matricula(a3);

		curso.getAlunos().forEach(aluno -> System.out.println(aluno));
		validaAlunoMatriculado(curso, a1);

		Aluno allen = new Aluno("Barry Allen", 1);
		validaAlunoMatriculado(curso, allen);
		
	}

	public static void validaAlunoMatriculado(Curso curso, Aluno aluno) {
		String retorno = curso.alunoEstaMatriculado(aluno) ? "Sim" : "Não";
		System.out.println("Aluno " + aluno.getNome() + " esta matriculado? " + retorno);
	}

}
