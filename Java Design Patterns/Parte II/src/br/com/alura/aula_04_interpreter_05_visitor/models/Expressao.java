package br.com.alura.aula_04_interpreter_05_visitor.models;

public interface Expressao {
	
	void aceita(Visitor visitor);
	int calcula();

}
