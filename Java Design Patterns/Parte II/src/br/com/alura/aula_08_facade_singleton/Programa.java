package br.com.alura.aula_08_facade_singleton;

import br.com.alura.aula_08_facade_singleton.models.Cliente;
import br.com.alura.aula_08_facade_singleton.models.Cobranca;
import br.com.alura.aula_08_facade_singleton.models.Fatura;
import br.com.alura.aula_08_facade_singleton.models.Tipo;

public class Programa {
	public static void main(String[] args) {
		EmpresaFacade facade = new EmpresaFacadeSingleton().getInstancia();

		double valor = 100;

		Cliente cliente = new Cliente();
		Fatura fatura = new Fatura(cliente, valor);

		facade.buscaCliente("");
		facade.criaFatura(cliente, valor);
		facade.fazContato(cliente, new Cobranca(Tipo.BOLETO, fatura));
		facade.geraCobranca(fatura);

	}
}
