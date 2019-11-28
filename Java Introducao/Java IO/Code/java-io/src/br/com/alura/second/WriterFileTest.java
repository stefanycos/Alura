package br.com.alura.second;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriterFileTest {

	public static void main(String[] args) throws IOException {
		writeFile();
	}

	private static void writeFile() throws IOException {

		OutputStream outputStream = new FileOutputStream("loremTest.txt");
		Writer writer = new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);

		bufferedWriter.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		bufferedWriter.newLine();
		bufferedWriter.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

		bufferedWriter.close();
	}

}