package br.com.alura.banheiro;

public class BanheiroSync {

	private boolean estaSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (estaSujo)
				esperaLaFora(nome);

			System.out.println(nome + " fazendo coisa rapida");

			sleep(5000);

			estaSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (estaSujo)
				this.esperaLaFora(nome);

			System.out.println(nome + " fazendo coisa demorada");

			this.sleep(8000);

			estaSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	public void limpa() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			if (!estaSujo) {
				System.out.println(nome + ", não está sujo, vou sair");
				return;
			}

			System.out.println(nome + " limpando o banheiro");
			this.estaSujo = false;

			this.sleep(13000);
			this.notifyAll();

			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, o banheiro esta sujo");

		try {
			this.wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
