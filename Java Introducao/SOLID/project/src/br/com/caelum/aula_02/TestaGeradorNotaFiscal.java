package br.com.caelum.aula_02;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.aula_02.dao.NotaFiscalDAO;
import br.com.caelum.aula_02.email.NotaFiscalEmail;
import br.com.caelum.aula_02.models.Fatura;
import br.com.caelum.aula_02.service.GeradorNotaFiscalService;
import br.com.caelum.aula_02.service.NotaFiscalSender;

public class TestaGeradorNotaFiscal {

	public static void main(String[] args) {
		List<NotaFiscalSender> senders = new ArrayList<>();
		senders.add(new NotaFiscalDAO());
		senders.add(new NotaFiscalEmail());
		
		GeradorNotaFiscalService service = new GeradorNotaFiscalService(senders);
		service.gera(new Fatura(300, "Stepehn"));

	}

}
