package br.com.alura.commands;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Stefany Souza
 * This class could implements Runnable instead of Callable, due to the fact that we don't have a return 
 * But we are implementing Callable only show how to pass a Generic with type Void, that is, with no returns
 */
public class JoinResultFutureWSAndDB implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureDB;
	private PrintStream output;
	
	public JoinResultFutureWSAndDB(Future<String> futureWS, Future<String> futureDB, PrintStream output) {
		this.futureWS = futureWS;
		this.futureDB = futureDB;
		this.output = output;
	}


	@Override
	public Void call() {
		System.out.println("Wating results from Future WS and Data Base");
		
		try {
			//Getting the future return, we will wait only for 20 seconds for the result from the thread, after that an exception will be thrown
			String magicNumberWS = this.futureWS.get(20, TimeUnit.SECONDS);
			String magicNumberDB = this.futureDB.get(20, TimeUnit.SECONDS);
			
			this.output.print("Results command C2 - WS " + magicNumberWS + " | DataBase " + magicNumberDB);
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			
			System.out.println("Timeout: cancelling command C2 execution");
			
			//Here we need to cancel both tasks because one depends another, so when one go bad other have to stop also
			this.futureWS.cancel(true);
			this.futureDB.cancel(true);
			
			this.output.print("A timeout occurred in command C2 execution");
		} 
		
		System.out.println("JoinResultFutureWSAndDB finalized!");
		
		return null;
	}

}
