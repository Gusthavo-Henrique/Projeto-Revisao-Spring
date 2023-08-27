package br.com.gusthavo.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.gusthavo.services.exceptions.ClientIdNotFoundException;

@ControllerAdvice
@RestController
public class HandlerException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StandardError> handleAllExceptions(Exception e, WebRequest request) {
		StandardError exceptionResponse = new StandardError(new Date(), 
				e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ClientIdNotFoundException.class)
	public final ResponseEntity<StandardError> handlerClientIdNotFound(Exception e, WebRequest request) {
		StandardError err = new StandardError(new Date(), e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
}
