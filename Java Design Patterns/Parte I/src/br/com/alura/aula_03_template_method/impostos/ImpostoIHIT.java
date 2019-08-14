package br.com.alura.aula_03_template_method.impostos;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.aula_03_template_method.models.Item;
import br.com.alura.aula_03_template_method.models.Orcamento;

public class ImpostoIHIT extends ImpostoTemplate {

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<String>();

		for (Item item : orcamento.getItens()) {
			if (noOrcamento.contains(item.getNome()))
				return true;
			else
				noOrcamento.add(item.getNome());
		}

		return false;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * (0.01 * orcamento.getItens().size());
	}
}
