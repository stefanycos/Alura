package br.com.caelum.aula_02.email;

import br.com.caelum.aula_02.models.NotaFiscal;
import br.com.caelum.aula_02.service.NotaFiscalSender;

public class NotaFiscalEmail implements NotaFiscalSender {

	@Override
	public void processa(NotaFiscal nf) {
		System.out.println("Envia email da Nota Fiscal " + nf.getValorLiquido());
	}

}
