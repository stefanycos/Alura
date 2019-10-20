package br.com.alura.threads;

public class Principal {

	public static void main(String[] args) {
		
		Runnable print = new ImprimeString();
		Thread threadPrint = new Thread(print, "Print-String");
		threadPrint.start();
		
	}

}
