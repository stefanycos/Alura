package br.com.alura.banheiro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BanheiroLock {

	private static final Lock LOCK = new ReentrantLock();
	
	public void fazNumero1() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		LOCK.lock();
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa rapida");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		LOCK.unlock();

	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		LOCK.lock();
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa demorada");
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		LOCK.unlock();

	}

}
