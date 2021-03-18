package br.com.zupacademy.ricardo.casadocodigo.controllers;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zupacademy.ricardo.casadocodigo.controllers.dto.ResponseError;

@RestControllerAdvice
public class ValidationErrorsController {

	private MessageSource messageSource;

	public ValidationErrorsController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseError errosValidacao(MethodArgumentNotValidException exception) {

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		return criarResponseError(fieldErrors);
	}


	private ResponseError criarResponseError(List<FieldError> fieldErrors) {
		ResponseError response = new ResponseError();
		fieldErrors.forEach(erro -> {
			String errorMessage = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			response.addErro(erro.getField(), errorMessage);
		});
		return response;
	}
}
