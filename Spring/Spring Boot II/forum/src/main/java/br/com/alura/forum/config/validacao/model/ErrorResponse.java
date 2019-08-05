package br.com.alura.forum.config.validacao.model;

public class ErrorResponse {

	private String mensagem;
	private String status;
	private String erro;

	public ErrorResponse(String mensagem, String status, String erro) {
		this.mensagem = mensagem;
		this.status = status;
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getStatus() {
		return status;
	}

	public String getErro() {
		return erro;
	}

}
