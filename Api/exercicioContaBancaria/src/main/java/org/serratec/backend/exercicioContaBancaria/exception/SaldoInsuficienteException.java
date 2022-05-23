package org.serratec.backend.exercicioContaBancaria.exception;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 6747250531709668544L;

	public SaldoInsuficienteException() {
		super();
	}

	public SaldoInsuficienteException(String message) {
		super(message);
	}
}
