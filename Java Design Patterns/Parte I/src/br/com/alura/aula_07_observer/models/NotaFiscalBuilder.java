package br.com.alura.aula_07_observer.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.alura.aula_07_observer.observers.NotaFiscalObserver;

public class NotaFiscalBuilder {

	private String razaoSocial;

	private String cnpj;

	private List<ItemDaNota> todosItens = new ArrayList<>();

	private double valorBruto;

	private double impostos;

	private String observacao;

	private Calendar dataEmissao;

	private List<NotaFiscalObserver> observers;

	public NotaFiscalBuilder() {
		this.dataEmissao = Calendar.getInstance();
		observers = new ArrayList<>();
	}

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

	public NotaFiscalBuilder naData(Calendar data) {
		dataEmissao = data;
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.5;
		return this;
	}

	public void adicionaObserver(NotaFiscalObserver observer) {
		this.observers.add(observer);
	}

	public NotaFiscal build() {
		NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, dataEmissao, valorBruto, impostos, todosItens, observacao);

		for (NotaFiscalObserver observer : observers) {
			observer.execute(nf);
		}
		return nf;
	}

}
