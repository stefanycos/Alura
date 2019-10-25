package br.com.caelum.aula_01.models;

import br.com.caelum.aula_01.service.calculos.DezOuVintePorcentoCalc;
import br.com.caelum.aula_01.service.calculos.QuinzeOuVinteCincoPorcento;
import br.com.caelum.aula_01.service.calculos.RegraDeCalculo;

public enum Cargo {

	DESENVOLVEDOR(new DezOuVintePorcentoCalc()),
	DBA(new QuinzeOuVinteCincoPorcento()),
	TESTER(new QuinzeOuVinteCincoPorcento());

	private RegraDeCalculo regra;

	private Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}
	
	public RegraDeCalculo getRegra() {
		return regra;
	}

}
