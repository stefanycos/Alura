package br.com.alura.second;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriterConsoleTest {

	public static BufferedReader readFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("lorem.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
		return new BufferedReader(inputStreamReader);
	}

	public static void printFile(BufferedReader reader) throws IOException {
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

}
