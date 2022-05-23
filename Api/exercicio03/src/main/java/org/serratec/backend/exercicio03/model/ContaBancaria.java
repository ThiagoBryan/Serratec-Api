// Crie uma aplicação para gerenciar contas bancarias:
//Entidade: numero, titular, saldo;
//Operação: tipo(debito/credito), valor;
//API: GET /conta-lista todas as contas,
// GET/conta/<numero> - retorna a conta com o numero passado,
// POST /conta - insere uma nova conta,
// PUT /conta/numero/operacao - recebe uma operacao com parametro e a partir dela atualiza o saldo,
//DELETE /conta/numero - remove a conta cujo numero foi passado;
// Tratamento de erro para saldo insuficiente(operação de debito com valor maior que o saldo);

package org.serratec.backend.exercicio03.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // para dizer que é entidade
@Table(name="contaBancaria")
public class ContaBancaria {

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idNumeroConta;
	private String titular;
	private double saldo;

	// CONSTRUTOR VAZIO
	public ContaBancaria() {
		super();
	}

//	// CONSTRUTOR
//	public ContaBancaria(Integer idNumeroConta, String titular, double saldo) {
//		super();
//		this.idNumeroConta = idNumeroConta;
//		this.titular = titular;
//		this.saldo = saldo;
//	}

	// GETTERS AND SETTERS

	public Integer getNumeroConta() {
		return idNumeroConta;
	}

	public void setNumeroConta(Integer idNumeroConta) {
		this.idNumeroConta = idNumeroConta;
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
