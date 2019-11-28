package br.com.alura.aula_08_facade_singleton;

class ServicoSingleton {
	private static Servico instancia;

	public Servico getInstancia() {
		if (instancia == null) {
			instancia = new Servico();
		}
		return instancia;
	}
}