package br.com.gusthavo.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ClientIdNotFoundException(String msg) {
		super(msg);
	}
}
