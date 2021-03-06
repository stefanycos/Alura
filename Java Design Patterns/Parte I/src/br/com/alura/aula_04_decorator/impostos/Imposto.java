package br.com.alura.aula_04_decorator.impostos;

import br.com.alura.aula_04_decorator.models.Orcamento;

public abstract class Imposto {

	protected final Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	public Imposto() {
		this.outroImposto = null;
	}

	protected double calculoDoOutroImposto(Orcamento orcamento) {
		if(outroImposto == null) {
			return 0;
		}
		return outroImposto.calcula(orcamento);
	}

	public abstract double calcula(Orcamento orcamento);

}
