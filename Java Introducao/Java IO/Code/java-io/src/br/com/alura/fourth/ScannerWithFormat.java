package br.com.alura.fourth;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScannerWithFormat {

	private static final String LANGUAGE = "pt";
	private static final String COUNTRY = "BR";

	public static void main(String[] args) throws IOException {
		readCount();
	}
	
	private static void readCount() throws IOException {

		Scanner scanner = new Scanner(new File("contas.csv"));
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			Scanner scannerLine = new Scanner(line);
			scannerLine.useLocale(Locale.US);
			scannerLine.useDelimiter(",");

			System.out.println(createAndFormatCount(scannerLine));
		}

		scanner.close();
	}

	private static String createAndFormatCount(Scanner scanner) {

		String countType = scanner.next();
		int agency = scanner.nextInt();
		int number = scanner.nextInt();
		String titular = scanner.next();
		double balance = scanner.nextDouble();

		Locale locale = new Locale(LANGUAGE, COUNTRY);
		return String.format(locale, "Count Type: %s | Ag. %04d | Count: %04d | Titular: %s | Balance: %02.2f",
				countType, agency, number, titular, balance);
	}

}
