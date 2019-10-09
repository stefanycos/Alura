package br.com.alura.aula_07_observer.observers;

import br.com.alura.aula_07_observer.models.NotaFiscal;

public class Imprime implements NotaFiscalObserver {

	@Override
	public void execute(NotaFiscal notaFiscal) {
		System.out.println("Imprimindo nota fiscal...");
	}

}
