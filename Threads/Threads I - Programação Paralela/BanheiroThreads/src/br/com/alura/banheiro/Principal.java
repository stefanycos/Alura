package br.com.alura.banheiro;

public class Principal {

	public static void main(String[] args) {

		BanheiroSync banheiro = new BanheiroSync();

		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Jo�o");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
		limpeza.setDaemon(true);
		limpeza.setPriority(Thread.MAX_PRIORITY);
		
		convidado1.start();
		convidado2.start();
		limpeza.start();
	}

}
