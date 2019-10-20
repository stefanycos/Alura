package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {

	private BanheiroSync banheiro;

	public TarefaLimpeza(BanheiroSync banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		while (true) {
			banheiro.limpa();
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
