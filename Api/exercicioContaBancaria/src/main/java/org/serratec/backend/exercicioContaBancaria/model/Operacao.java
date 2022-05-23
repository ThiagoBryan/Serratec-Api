package org.serratec.backend.exercicioContaBancaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Operacao {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String tipo;
	private double valor;
	
	
	
	public Operacao() {
		super();
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
