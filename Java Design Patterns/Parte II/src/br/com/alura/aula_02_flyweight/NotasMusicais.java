package br.com.alura.aula_02_flyweight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.aula_02_flyweight.notas.Do;
import br.com.alura.aula_02_flyweight.notas.Fa;
import br.com.alura.aula_02_flyweight.notas.La;
import br.com.alura.aula_02_flyweight.notas.Mi;
import br.com.alura.aula_02_flyweight.notas.Nota;
import br.com.alura.aula_02_flyweight.notas.Re;
import br.com.alura.aula_02_flyweight.notas.Si;
import br.com.alura.aula_02_flyweight.notas.Sol;

public class NotasMusicais {

	private static Map<String, Nota> notas = new HashMap<>();
	private static List<Class<? extends Nota>> clazzes;

	static {
		clazzes = Arrays.asList(
				Do.class, Re.class, Mi.class, Fa.class, 
				Sol.class, La.class, Si.class);
	}

	public Nota pega(String nome) {
		try {
			
			if (!notas.containsKey(nome)) {
				for (Class<? extends Nota> clazz : clazzes) {
					if (clazz.getSimpleName().equalsIgnoreCase(nome)) {
						notas.put(nome, (Nota) clazz.newInstance());
						break;
					}
				}
			}

			return notas.get(nome);
		} catch (Exception e) {
			throw new RuntimeException(e); // NOSONAR
		}
	}
}
