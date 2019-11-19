package br.com.alura.aula_03_memento;

import java.util.Calendar;

import br.com.alura.aula_03_memento.models.Contrato;
import br.com.alura.aula_03_memento.models.Historico;
import br.com.alura.aula_03_memento.models.TipoContrato;

public class Main {

	public static void main(String[] args) {

		Historico historico = new Historico();

		Contrato contrato = new Contrato(Calendar.getInstance(), "Mauricio", TipoContrato.NOVO);
		historico.adiciona(contrato.salvaEstado());
		
		System.out.println("Estado atual: " + contrato.getTipo());
		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		System.out.println("Estado atual: " + contrato.getTipo());
		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		System.out.println("Estado atual: " + contrato.getTipo());
		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());
		
		contrato.restaura(historico.pega(1));
		
		System.out.println("Estado restaurado: " + contrato.getTipo());
	}

}
