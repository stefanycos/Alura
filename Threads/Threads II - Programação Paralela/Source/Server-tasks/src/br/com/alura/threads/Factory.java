package br.com.alura.threads;

import java.util.concurrent.ThreadFactory;

import br.com.alura.threads.exception.ExceptionHandler;

public class Factory implements ThreadFactory {

	private static int number = 1;

	@Override
	public Thread newThread(Runnable runnable) {

		Thread thread = new Thread(runnable, "Thread server tasks " + number);
		number++;
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.setDaemon(true);
		return thread;
	}

}
