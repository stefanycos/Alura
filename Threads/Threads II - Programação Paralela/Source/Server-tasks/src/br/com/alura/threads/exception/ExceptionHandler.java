package br.com.alura.threads.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable eThrowable) {
		System.out.println("An exception occurred in Thread " + thread.getName() + ", " + eThrowable.getMessage());
	}

}
