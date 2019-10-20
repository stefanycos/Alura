package br.com.alura.commands;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class CommandC2CallWS implements Callable<String> {

	
	@SuppressWarnings("unused")
	private PrintStream output;

	public CommandC2CallWS(PrintStream output) {
		this.output = output;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Server received command C2 - WS");
		System.out.println("Processing command C2 - WS");
		
		Thread.sleep(2000);

		//Used to test UncaughtExceptionHandler. To test it uncomment line bellow and comment all others bellow
		//throw new RuntimeException("Exception in command C2");
		
		int number = new Random().nextInt(100) + 1;
		System.out.println("Server finalized command C2 - WS");
		return String.valueOf(number);
	}

}
