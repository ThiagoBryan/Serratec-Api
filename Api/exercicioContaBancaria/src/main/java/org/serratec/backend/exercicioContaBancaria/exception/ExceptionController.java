package org.serratec.backend.exercicioContaBancaria.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<String> saldoInsuficienteException(SaldoInsuficienteException exception){
		String msg = String.format("Saldo insuficiente");
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "SALDO INSUFICIENTE")
				.header("x-erro-value")
				.build();
	}
	
	@ExceptionHandler(ArgumentoInvalidoException.class)
	public ResponseEntity<String> argumentoInvalidoException(ArgumentoInvalidoException exception){
		String msg = String.format("OPÇÃO INVÁLIDA");
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "OPÇÃO INVÁLIDA")
				.header("x-erro-value")
				.build();
	}

}
