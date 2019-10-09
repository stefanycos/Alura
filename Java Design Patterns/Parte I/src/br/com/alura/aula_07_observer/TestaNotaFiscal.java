package br.com.alura.aula_07_observer;

import br.com.alura.aula_07_observer.models.ItemDaNota;
import br.com.alura.aula_07_observer.models.NotaFiscal;
import br.com.alura.aula_07_observer.models.NotaFiscalBuilder;
import br.com.alura.aula_07_observer.observers.EnviaPorEmail;
import br.com.alura.aula_07_observer.observers.EnviaPorSms;
import br.com.alura.aula_07_observer.observers.Imprime;
import br.com.alura.aula_07_observer.observers.Multiplicador;

public class TestaNotaFiscal {

	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.adicionaObserver(new Imprime());
		builder.adicionaObserver(new EnviaPorEmail());
		builder.adicionaObserver(new EnviaPorSms());
		builder.adicionaObserver(new Multiplicador(10));
		
		NotaFiscal notaFiscal = builder.paraEmpresa("Caelum")
			.comCNPJ("12.155.165/0001-01")
			.comObservacao("Teste")
			.comItem(new ItemDaNota("Curso Spring", 1500.00)).build();
		
		System.out.println(notaFiscal);
	}

}
