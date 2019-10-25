package br.com.caelum.aula_01.service;

import br.com.caelum.aula_01.models.Funcionario;

public class FuncionarioService {

	public double calcula(Funcionario funcionario) {
		return funcionario.calculaSalario();
	}

}
