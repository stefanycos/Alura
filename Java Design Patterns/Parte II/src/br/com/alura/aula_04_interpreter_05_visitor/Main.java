package br.com.alura.aula_04_interpreter_05_visitor;

import br.com.alura.aula_04_interpreter_05_visitor.models.Expressao;
import br.com.alura.aula_04_interpreter_05_visitor.models.Numero;
import br.com.alura.aula_04_interpreter_05_visitor.models.RaizQuadrada;
import br.com.alura.aula_04_interpreter_05_visitor.models.Soma;
import br.com.alura.aula_04_interpreter_05_visitor.models.Subtracao;
import br.com.alura.aula_04_interpreter_05_visitor.service.Impressora;
import br.com.alura.aula_04_interpreter_05_visitor.service.ImpressoraPreFixa;

public class Main {

	public static void main(String[] args) {
		
		Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
		Expressao direita = new Soma(new Numero(2), new RaizQuadrada(new Numero(4)));

		Expressao conta = new Soma(esquerda, direita);
		
		int resultado = conta.calcula();
		System.out.println(resultado);
		
		Impressora impressora = new Impressora();
		conta.aceita(impressora);
		
		System.out.println();
		
		ImpressoraPreFixa imPreFixa = new ImpressoraPreFixa();
		conta.aceita(imPreFixa);
		
	}

}
