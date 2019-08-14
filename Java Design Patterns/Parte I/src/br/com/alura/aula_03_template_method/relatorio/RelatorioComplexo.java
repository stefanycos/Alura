package br.com.alura.aula_03_template_method.relatorio;

import java.util.Calendar;
import java.util.List;

import br.com.alura.aula_03_template_method.models.Conta;

public class RelatorioComplexo extends Relatorio {
	protected void cabecalho() {
		System.out.println("Banco XYZ");
		System.out.println("Avenida Paulista, 1234");
		System.out.println("(11) 1234-5678");
	}

	protected void rodape() {
		System.out.println("banco@xyz.com.br");
		System.out.println(Calendar.getInstance().getTime());
	}

	protected void corpo(List<Conta> contas) {
		for (Conta conta : contas) {
			System.out.println(conta.getTitular() + " - " + conta.getBanco() + " - " + conta.getAgencia() + " - "
					+ conta.getSaldo());
		}
	}
}