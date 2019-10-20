package br.com.alura.threads.listas;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroDaThread;

	public TarefaAdicionarElemento(Lista lista, int numeroDaThread) {
		this.lista = lista;
		this.numeroDaThread = numeroDaThread;

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.adicionaElemento("Thread: " + numeroDaThread + " - " + i);
		}

	}

}
