package br.com.alura.banheiro;

public class TarefaNumero2 implements Runnable {

	private BanheiroSync banheiro;
	
	public TarefaNumero2(BanheiroSync banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero2();
	}

}
