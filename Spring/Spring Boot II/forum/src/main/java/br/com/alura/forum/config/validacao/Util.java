package br.com.alura.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;

import br.com.alura.forum.config.validacao.model.ErrorResponse;
import br.com.alura.forum.config.validacao.model.ErrorResponseForm;

public class Util {
	
	private Util() {}

	
	public static ErrorResponse createErrorResponseNotFound(Exception exception) {
		return new ErrorResponse(exception.getMessage(), "400", "Bad Request");
	}
	
	public static List<ErrorResponseForm> createFormErrorResponse(List<FieldError> fieldErrors, MessageSource messageSource) {
		List<ErrorResponseForm> formErrors = new ArrayList<>();

		for (FieldError e : fieldErrors) {

			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorResponseForm erro = new ErrorResponseForm(e.getField(), mensagem);
			formErrors.add(erro);
		}

		return formErrors;
	}

}
