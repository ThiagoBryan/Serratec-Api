package org.serratec.backend.biblioteca.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // controlar as exceptions
public class ExceptionController {


// NO SALVAR
@ExceptionHandler(ArgumentoInvalidoException.class)
public ResponseEntity<String> argumentoInvalidoException(ArgumentoInvalidoException exception) {
	String msg = String.format("O título não foi preenchido");
	return ResponseEntity.badRequest()
			.header("x-erro-msg", msg)
			.header("x-erro-code", "Titulo vazio")
			.header("x-erro-value")
			.build();
}
	
	@ExceptionHandler(value 
		      = {LivroException.class })
	protected ResponseEntity<Object> naoEncontrado(LivroException ex) {		
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
