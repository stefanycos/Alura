package br.com.alura.forum.config.validacao.model;

public class ErrorResponseForm {
	
	private String campo;
	private String erro;
	
	public ErrorResponseForm(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
