package br.com.alura.aula_03_template_method.relatorio;

import java.util.List;

import br.com.alura.aula_03_template_method.models.Conta;

public abstract class Relatorio {
	
	protected abstract void cabecalho();

	protected abstract void rodape();

	protected abstract void corpo(List<Conta> contas);

	public void imprime(List<Conta> contas) {
		cabecalho();
		corpo(contas);
		rodape();
	}
}