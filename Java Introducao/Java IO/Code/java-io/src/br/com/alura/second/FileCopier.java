package br.com.alura.second;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class FileCopier {

	public static void main(String[] args) throws Exception {
		readeFromConsole();
	}

	public static BufferedReader readerFile() throws Exception {
		InputStream inputStream = new FileInputStream("lorem.txt");
		Reader reader = new InputStreamReader(inputStream);
		return new BufferedReader(reader);
	}

	public static void readeFromConsole() throws Exception {
		InputStream fis = System.in;
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		OutputStream fos = new FileOutputStream("lorem2.txt");
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		String linha = br.readLine();

		while (linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			linha = br.readLine();
		}

		br.close();
		bw.close();
	}

	public static BufferedWriter fileWriter() throws Exception {
		OutputStream outputStream = new FileOutputStream("lorem2.txt");
		Writer writer = new OutputStreamWriter(outputStream);
		return new BufferedWriter(writer);
	}

	public static void writeInConsole() throws Exception {
		BufferedReader readerFile = readerFile();
		String line = readerFile.readLine();

		while (line != null) {
			System.out.println(line);
			line = readerFile.readLine();
		}

		readerFile.close();
	}

	public static void writeInIFile() throws Exception {
		BufferedReader readerFile = readerFile();
		BufferedWriter writer = fileWriter();

		String line = readerFile.readLine();

		while (line != null) {
			writer.write(line);
			writer.newLine();
			line = readerFile.readLine();
		}

		readerFile.close();
		writer.close();
	}

}
