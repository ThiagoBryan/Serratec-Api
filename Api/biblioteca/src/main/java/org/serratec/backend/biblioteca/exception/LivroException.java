package org.serratec.backend.biblioteca.exception;

public class LivroException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	//no buscar
	public LivroException(String titulo) {
		this.titulo=titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

}
