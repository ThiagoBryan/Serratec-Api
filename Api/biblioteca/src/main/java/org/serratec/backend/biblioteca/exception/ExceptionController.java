package org.serratec.backend.biblioteca.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice// para controlar as exceptions
public class ExceptionController {
	
	// NO BUSCAR
	// tambem para controlar as exeptions
	@ExceptionHandler(LivroException.class)
	public ResponseEntity<String> trataLivroNotFound(LivroException exception) {
		String msg = String.format("O livro com o título não foi encontrado", exception.getTitulo());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "Livro NOT FOUND")
				.header("x-erro-value", exception.getTitulo().toString())
				.build();
	}
	
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


}
