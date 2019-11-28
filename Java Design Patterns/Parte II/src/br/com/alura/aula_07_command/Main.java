package br.com.alura.aula_07_command;

import br.com.alura.aula_07_command.actions.FinalizaPedido;
import br.com.alura.aula_07_command.actions.PagaPedido;
import br.com.alura.aula_07_command.models.Pedido;
import br.com.alura.aula_07_command.service.Fila;

public class Main {

	public static void main(String[] args) {
		Pedido pedido1 = new Pedido("Elizabete Ken", 100);
		Pedido pedido2 = new Pedido("Raymond Raddington", 2000);

		Fila fila = new Fila();
		fila.adiciona(new PagaPedido(pedido1));
		fila.adiciona(new FinalizaPedido(pedido2));
		fila.adiciona(new FinalizaPedido(pedido1));

		fila.processa();
	}
}
