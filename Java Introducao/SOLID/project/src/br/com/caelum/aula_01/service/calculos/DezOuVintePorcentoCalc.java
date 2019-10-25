package br.com.caelum.aula_01.service.calculos;

import br.com.caelum.aula_01.models.Funcionario;

public class DezOuVintePorcentoCalc implements RegraDeCalculo {

	@Override
	public double calcula(Funcionario funcionario) {
		if (funcionario.getSalarioBase() > 3000.0) {
			return funcionario.getSalarioBase() * 0.8;
		} else {
			return funcionario.getSalarioBase() * 0.9;
		}
	}

}
