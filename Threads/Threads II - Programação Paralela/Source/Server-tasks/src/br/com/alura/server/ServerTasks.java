package br.com.alura.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import br.com.alura.threads.Factory;

/**
 * @author Stefany Souza
 * 
 *         This is a server class, responsible for listening client requests
 *
 */
public class ServerTasks {

	private ServerSocket server;
	private ExecutorService threadPool;
	private AtomicBoolean isRunning;


	public ServerTasks() throws IOException {
		System.out.println("----- Initializing Server -----");
		this.server = new ServerSocket(12345);
		this.threadPool = Executors.newFixedThreadPool(4, new Factory()); //newFixedThreadPool(1)
		this.isRunning = new AtomicBoolean(true);
	}

	public static void main(String[] args) throws IOException {
		ServerTasks serverTasks = new ServerTasks();
		serverTasks.run();
	}

	public void stop() throws IOException {
		this.isRunning.set(false);
		threadPool.shutdown();
		server.close();
	}

	private void run() throws IOException {

		// Doing this to accept more than one connection
		while (this.isRunning.get()) {

			try {
				// The accept method is blocker and lock the main thread, that means the main thread will stay blocked until received a connection from a client
				Socket socket = server.accept();
				System.out.println("Accepting several clients in port " + socket.getPort());

				// Putting any request in a different thread
				DistributeTasks tasks = new DistributeTasks(threadPool, socket, this);
				threadPool.execute(tasks);
				
			} catch (Exception e) {
				System.out.println("Socket Status: " + this.isRunning);
			}
		}
	}

}
