package br.com.alura.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import br.com.alura.commands.CommandC1;
import br.com.alura.commands.CommandC2AccessDB;
import br.com.alura.commands.CommandC2CallWS;
import br.com.alura.commands.JoinResultFutureWSAndDB;

public class DistributeTasks implements Runnable {

	private Socket socket;
	private ServerTasks serverTasks;
	private ExecutorService threadPool;

	public DistributeTasks(ExecutorService threadPool, Socket socket, ServerTasks serverTasks) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.serverTasks = serverTasks;
	}

	@Override
	public void run() {
		try {

			System.out.println("Distributing tasks for the client " + socket);

			// Receiving a command from client
			Scanner clientInput = new Scanner(socket.getInputStream());
			PrintStream clientOut = new PrintStream(socket.getOutputStream());

			while (clientInput.hasNextLine()) {
				String command = clientInput.nextLine();
				System.out.println("Command Received: " + command);

				switch (command) {
				case "C1":
					clientOut.println("Command " + command + " confirmed!");
					CommandC1 commandC1 = new CommandC1(clientOut);
					this.threadPool.execute(commandC1);
					break;
				case "C2":
					
					clientOut.println("Command " + command + " confirmed!");
					CommandC2CallWS commandC2WS = new CommandC2CallWS(clientOut);
					CommandC2AccessDB commandC2BD = new CommandC2AccessDB(clientOut);
					
					Future<String> futureWS = this.threadPool.submit(commandC2WS);
					Future<String> futureDB = this.threadPool.submit(commandC2BD);
					
					//In this class JoinResultFutureWSAndDB we get the future result in another thread, to avoid this thread to be blocked while waits the future result  
					Callable<Void> joinResults = new JoinResultFutureWSAndDB(futureWS, futureDB, clientOut);
					this.threadPool.submit(joinResults);
					
					break;
				case "END":
					clientOut.println("Shutting down server");
					serverTasks.stop();
					return;
				default:
					clientOut.println("Command " + command + " not found!");
					break;
				}
			}

			clientOut.close();
			clientInput.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

