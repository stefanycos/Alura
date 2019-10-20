package br.com.alura.commands;

import java.io.PrintStream;

public class CommandC1 implements Runnable {

	private PrintStream output;

	public CommandC1(PrintStream output) {
		this.output = output;
	}

	@Override
	public void run() {
		System.out.println("Executing command C1");
		this.sleep(20000);
		output.println("Command C1 executed sucessfully!");
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
