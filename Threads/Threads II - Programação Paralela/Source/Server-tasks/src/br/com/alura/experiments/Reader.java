package br.com.alura.experiments;

import java.io.FileReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

public class Reader implements UncaughtExceptionHandler {

	public static void main(String[] args) {
		Properties properties = new Properties();
		Thread thread = new Thread(new PropertyReader(properties, "file.txt"));
		thread.setUncaughtExceptionHandler(new Reader());
		thread.start();
	}

	public static class PropertyReader implements Runnable {

		private Properties propriedades;
		private String fileName;

		public PropertyReader(Properties propriedades, String nomeArquivo) {
			this.propriedades = propriedades;
			this.fileName = nomeArquivo;
		}

		public void run() {
			try {
				this.propriedades.load(new FileReader(fileName));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {

		System.out.println("Excpetion occurred in Thread: " + thread.getName() + ", " + ex.getMessage());

	}

}
