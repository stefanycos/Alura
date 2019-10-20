package br.com.alura.commands;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class CommandC2AccessDB implements Callable<String> {

	@SuppressWarnings("unused")
	private PrintStream output;

	public CommandC2AccessDB(PrintStream output) {
		this.output = output;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Server received command C2 - Access Data Base");
		System.out.println("Processing command C2 - Access Data Base");

		Thread.sleep(2000);

		int number = new Random().nextInt(100) + 1;
		System.out.println("Server finalized command C2 - Access Data Base");
		return String.valueOf(number);
	}

}
