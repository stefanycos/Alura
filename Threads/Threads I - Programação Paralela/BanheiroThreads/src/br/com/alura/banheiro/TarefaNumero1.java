package br.com.alura.banheiro;

public class TarefaNumero1 implements Runnable {

	private BanheiroSync banheiro;
	
	public TarefaNumero1(BanheiroSync banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero1();
	}

}
