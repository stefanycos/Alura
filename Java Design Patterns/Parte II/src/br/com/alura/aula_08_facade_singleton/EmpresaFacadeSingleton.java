package br.com.alura.aula_08_facade_singleton;

public class EmpresaFacadeSingleton {
	private static EmpresaFacade instancia;
	
	public EmpresaFacade getInstancia(){
		if(instancia == null){
			instancia = new EmpresaFacade();
		}
		return instancia;
	}
}
