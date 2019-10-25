package br.com.caelum.aula_02.service;

import java.util.List;

import br.com.caelum.aula_02.models.Fatura;
import br.com.caelum.aula_02.models.NotaFiscal;

public class GeradorNotaFiscalService {

	private List<NotaFiscalSender> senders;

	public GeradorNotaFiscalService(List<NotaFiscalSender> senders) {
		this.senders = senders;
	}

	public NotaFiscal gera(Fatura fatura) {

		double valor = fatura.getValorMensal();

		NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));

		for (NotaFiscalSender notaFiscalSender : senders) {
			notaFiscalSender.processa(nf);
		}

		return nf;
	}

	private double impostoSimplesSobreO(double valor) {
		return valor * 0.06;
	}
}
