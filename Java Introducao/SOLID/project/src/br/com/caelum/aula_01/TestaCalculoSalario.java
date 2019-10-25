package br.com.caelum.aula_01;

import java.util.Calendar;

import br.com.caelum.aula_01.models.Cargo;
import br.com.caelum.aula_01.models.Funcionario;
import br.com.caelum.aula_01.service.FuncionarioService;

public class TestaCalculoSalario {
	
	public static void main(String[] args) {
		Funcionario desenvolvedor = new Funcionario(1, "Dimmy Swither", Cargo.DESENVOLVEDOR, Calendar.getInstance(), 5.300);
		Funcionario tester = new Funcionario(1, "Dimmy Swither", Cargo.TESTER, Calendar.getInstance(), 5.300);
		
		FuncionarioService service = new FuncionarioService();
		double salarioDev = service.calcula(desenvolvedor);
		double salarioTester = service.calcula(tester);
		
		System.out.println("Salário desenvolvedor: " + salarioDev + "\nSalário tester: " + salarioTester);
	}

}
