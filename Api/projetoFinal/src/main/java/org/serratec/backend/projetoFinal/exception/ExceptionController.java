package org.serratec.backend.projetoFinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // controlar as exceptions
public class ExceptionController {
	
	@ExceptionHandler(value 
		      = {ClienteException.class })
	protected ResponseEntity<Object> naoEncontrado(ClienteException ex) {		
		APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
//	       LOGGER.error(ex.getMessage(), ex);
	       return buildResponseEntity(apiError);
	   }
	@ExceptionHandler(value 
		      = {EnderecoException.class })
	protected ResponseEntity<Object> naoEncontrado(EnderecoException ex) {		
		APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
//	       LOGGER.error(ex.getMessage(), ex);
	       return buildResponseEntity(apiError);
	   }
	
	private ResponseEntity<Object> buildResponseEntity(APIError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	
	

}
