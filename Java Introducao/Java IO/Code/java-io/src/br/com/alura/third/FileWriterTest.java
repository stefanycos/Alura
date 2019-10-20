package br.com.alura.third;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public void test() throws Exception {
		FileWriter fw = new FileWriter("lorem2.txt");

		fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		fw.write(System.lineSeparator());
		fw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

		fw.close();
	}

	public void test2() throws IOException {
		FileWriter fw = new FileWriter("lorem2.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		bw.newLine();
		bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

		bw.close();
	}
}
