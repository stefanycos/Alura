package br.com.alura.aula_07_command.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.aula_07_command.actions.Comando;

public class Fila {

	private List<Comando> comandos;

	public Fila() {
		comandos = new ArrayList<>();
	}

	public void adiciona(Comando comando) {
		comandos.add(comando);
	}

	public void processa() {
		for (Comando comando : comandos) {
			comando.executa();
		}
	}
}
