package br.com.alura.aula_06.adapter;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Calendar agora = new Relogio().hoje();
		System.out.println(agora);
	}

}
