package org.serratec.backend.exercicioContaBancaria.exception;

public class ArgumentoInvalidoException extends Exception {


	private static final long serialVersionUID = -8954364681011643757L;

	public ArgumentoInvalidoException() {
		super();
	}

	public ArgumentoInvalidoException(String message) {
		super(message);
	}
}
