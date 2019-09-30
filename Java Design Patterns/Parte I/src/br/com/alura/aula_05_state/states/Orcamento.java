package br.com.alura.aula_05_state.states;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.aula_05_state.models.Item;

public class Orcamento {

	private double valor;
	protected EstadoDeUmOrcamento estadoAtual;
	private final List<Item> itens;

	public Orcamento(double valor) {
		this.setValor(valor);
		this.itens = new ArrayList<>();
		this.estadoAtual = new EmAprovacao();
	}
	
	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontoExtra(this);
	}
	
	public void aprova() {
		estadoAtual.aprova(this);
	}
	
	public void reprova() {
		estadoAtual.reprova(this);
	}
	
	public void finaliza() {
		estadoAtual.finaliza(this);
	}

	public double getValor() {
		return valor;
	}

	public void adicionaItem(Item item) {
		this.itens.add(item);
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public EstadoDeUmOrcamento getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(EstadoDeUmOrcamento estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

}
