package br.com.alura.aula_07_observer.observers;

import br.com.alura.aula_07_observer.models.NotaFiscal;

public interface NotaFiscalObserver {
	
	public void execute(NotaFiscal notaFiscal);

}
