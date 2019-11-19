package br.com.alura.aula_02_flyweight;

import java.util.Arrays;
import java.util.List;

import br.com.alura.aula_02_flyweight.notas.Nota;

public class Main {

	public static void main(String[] args) {
		NotasMusicais notas = new NotasMusicais();
		
		// Use fone
		List<Nota> musica = Arrays.asList(
				notas.pega("do"),
				notas.pega("si"),
				notas.pega("do"),
				notas.pega("re"),
				notas.pega("do"),
				notas.pega("si"),
				notas.pega("do"),
				notas.pega("re"),
				notas.pega("do"),
				notas.pega("si"),
				notas.pega("do"),
				notas.pega("si"),
				notas.pega("sol"));
		
		Piano.tocar(musica);
	}
}
