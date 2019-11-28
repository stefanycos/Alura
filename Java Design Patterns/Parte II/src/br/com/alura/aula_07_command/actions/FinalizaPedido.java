package br.com.alura.aula_07_command.actions;

import br.com.alura.aula_07_command.models.Pedido;

public class FinalizaPedido implements Comando {

	private Pedido pedido;
	
	public FinalizaPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public void executa() {
		System.out.println("Finalizando pedido: " + pedido.getCliente());
		pedido.finaliza();
	}

}
