package br.com.alura.aula_02_flyweight;

import java.util.List;

import org.jfugue.player.Player;

import br.com.alura.aula_02_flyweight.notas.Nota;

public class Piano {

	private Piano() {
	}

	public static void tocar(List<Nota> musica) {

		Player player = new Player();

		StringBuilder builder = new StringBuilder();

		for (Nota nota : musica) {
			builder.append(nota.simbolo() + " ");
		}

		player.play(builder.toString());
	}
}
