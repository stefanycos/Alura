package br.com.alura.aula_06_builder.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {

	private String razaoSocial;
	
	private String cnpj;
	
	private List<ItemDaNota> todosItens = new ArrayList<>();

	private double valorBruto;

	private double impostos;

	private String observacao;
	
	private Calendar dataEmissao;
	

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}
	
	public NotaFiscalBuilder comCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public NotaFiscalBuilder comObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}
	
	public NotaFiscalBuilder comDataAtual() {
		dataEmissao = Calendar.getInstance();
		return this;
	}
	
	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.5;
		return this;
	}
	
	public NotaFiscal build() {
		return new NotaFiscal(razaoSocial, cnpj, dataEmissao, valorBruto, impostos, todosItens, observacao);
	}

}
