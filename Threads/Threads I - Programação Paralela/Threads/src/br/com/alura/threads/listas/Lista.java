package br.com.alura.threads.listas;

public class Lista {

	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionaElemento(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;

		this.sleep(5);

		if (this.indice == this.tamanho()) {
			System.out.println("Lista está cheia, notificando");
			this.notify();
		}
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean estaCheia() {
		return this.indice == this.tamanho();
	}

}
