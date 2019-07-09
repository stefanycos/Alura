package br.com.casado.codigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casado.codigo.loja.models.CarrinhoCompras;
import br.com.casado.codigo.loja.models.DadosPagamento;

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;

	@Autowired
	private RestTemplate restTemplate;

	// Callable<ModelAndView> - desta forma os outros usuarios da aplicação poderão
	// utiliza-la, e apenas o usuario que esta esperando o resultado, fique
	// aguardando para saber se deu certo ou não a requisição
	@RequestMapping(value = "/finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(RedirectAttributes model) {
		// criação de classe anonima
		return () -> {

			String uri = "http://book-payment.herokuapp.com/payment";

			try {
				// String.class - classe retornada pela requisição, que neste caso retorna uma
				// mensagem, por usamos String.class
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()),
						String.class);
				System.out.println(response);

				model.addFlashAttribute("sucesso", response); // envia uma mensagem para proxima tela.
				return new ModelAndView("redirect:/produtos");
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				model.addFlashAttribute("falha", "Valor maior que o permitido!");
				return new ModelAndView("redirect:/produtos");
			}

		};

	}

}
