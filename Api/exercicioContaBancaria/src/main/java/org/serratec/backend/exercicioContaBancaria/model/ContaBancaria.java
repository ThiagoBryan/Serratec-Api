package org.serratec.backend.exercicioContaBancaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // para dizer que é entidade
@Table(name="contas")
public class ContaBancaria {

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numeroConta;
	private String titular;
	private double saldo;
	

	// CONSTRUTOR VAZIO
	public ContaBancaria() {
		super();
	}

	// GETTERS AND SETTERS

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer idNumeroConta) {
		this.numeroConta = idNumeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
