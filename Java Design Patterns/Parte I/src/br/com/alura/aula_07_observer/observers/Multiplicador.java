package br.com.alura.aula_07_observer.observers;

import br.com.alura.aula_07_observer.models.NotaFiscal;

public class Multiplicador implements NotaFiscalObserver {

	private final double fator;

	public Multiplicador(double fator) {
		this.fator = fator;
	}

	@Override
	public void execute(NotaFiscal notaFiscal) {
		System.out.println("Multiplicando... " + notaFiscal.getValorBruto() *  fator);
	}
	
	

}
