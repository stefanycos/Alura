package br.com.alura.aula_07_command.actions;

import br.com.alura.aula_07_command.models.Pedido;

public class PagaPedido implements Comando {

	private Pedido pedido;
	
	public PagaPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public void executa() {
		System.out.println("Pagando pedido: " + pedido.getCliente());
		pedido.paga();
	}

}
