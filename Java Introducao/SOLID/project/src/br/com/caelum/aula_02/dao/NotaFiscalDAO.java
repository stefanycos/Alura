package br.com.caelum.aula_02.dao;

import br.com.caelum.aula_02.models.NotaFiscal;
import br.com.caelum.aula_02.service.NotaFiscalSender;

public class NotaFiscalDAO implements NotaFiscalSender {

	@Override
	public void processa(NotaFiscal nf) {
		System.out.println("Salva Nota Fiscal no banco: " + nf.getValorLiquido());
	}

}
