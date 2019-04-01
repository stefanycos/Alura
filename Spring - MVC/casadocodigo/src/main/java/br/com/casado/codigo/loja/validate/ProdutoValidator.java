package br.com.casado.codigo.loja.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casado.codigo.loja.models.Produto;

public class ProdutoValidator implements Validator {

	private static final String FIELD_REQUIRED = "field.required";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", FIELD_REQUIRED);
		ValidationUtils.rejectIfEmpty(errors, "descricao", FIELD_REQUIRED);

		Produto produto = (Produto) target;
		if (produto.getPaginas() <= 0) {
			errors.rejectValue("paginas", FIELD_REQUIRED);
		}

	}

}
