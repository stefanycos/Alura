package br.com.alura.aula_06.bridge;

public class Main {

	public static void main(String[] args) {
		Mapa mapa = new GoogleMaps();
		System.out.println(mapa.getMapa());
	}

}
