package br.com.alura.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Stefany Souza
 * 
 *         This is client tasks, responsible for doing requests to the server
 * 
 */
public class ClientTasks {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 12345);
		System.out.println("Connection Established");

		Thread sendCommand = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Available to send commands...");

					// Sending the command (or any data) to server
					PrintStream out = new PrintStream(socket.getOutputStream());

					Scanner keyboard = new Scanner(System.in);

					// Reading any command typed
					while (keyboard.hasNextLine()) {
						String line = keyboard.nextLine();

						if (line.trim().equals("")) {
							break;
						}

						out.println(line);
					}

					out.close();
					keyboard.close();

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		Thread receiveAnswer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Receiving data from server");
					Scanner serverAnswer = new Scanner(socket.getInputStream());

					while (serverAnswer.hasNextLine()) {
						System.out.println(serverAnswer.nextLine());
					}

					serverAnswer.close();

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		receiveAnswer.start();

		sendCommand.start();
		sendCommand.join();

		socket.close();
	}
}
