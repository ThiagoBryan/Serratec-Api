package org.serratec.backend.exercicio02.model;

public class Jogo {
	private Integer id;
	private String titulo;
	private String empresa;
	
	//CONSTRUTOR VAZIO
	public Jogo() {
		
	}
	
	//CONSTRUTOR
	public Jogo(Integer id, String titulo, String empresa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.empresa = empresa;
	}
	
	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
