package br.com.alura.aula_06_builder;

import br.com.alura.aula_06_builder.models.ItemDaNota;
import br.com.alura.aula_06_builder.models.NotaFiscal;
import br.com.alura.aula_06_builder.models.NotaFiscalBuilder;

public class TestaNotaFiscal {

	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		
		NotaFiscal notaFiscal = builder.comCNPJ("412.124.125/0001-00")
			   .paraEmpresa("Alura Cursos")
			   .comItem(new ItemDaNota("Spring Boot", 70.50))
			   .comItem(new ItemDaNota("Spring MVC", 100.50))
			   .comObservacao("Obs qualquer")
			   .comDataAtual()
			   .build();
		
		System.out.println(notaFiscal);
	}

}
