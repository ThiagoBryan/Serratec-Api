package org.serratec.backend.projeto03.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cartao")
public class Cartao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartao_id")
	private Integer idCartao;
	
	@Column(name="cartao_limite")
	@NotNull
	private double limiteCartao;
	
	@Column(name="cartao_numero")
	@NotNull
	private String numeroCartao;
	
	@Column(name="cartao_nome_titular")
	@NotNull
	private String nomeTitular;
	
	@Column(name="cartao_data_validade")
	@NotNull
	private LocalDate dataValidade;
	
	@ManyToOne //PARA LIGAR AS CLASSES E SEMPRE CRIAR OS GETTERS AND SETTERS
	@JoinColumn(name="cliente_id", referencedColumnName = "cliente_cd_id")
	@JsonIgnore
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//CONTRUTOR VAZIO
	public Cartao() {
		super();
	}
	
	//GETTERS AND SETTERS

	public Integer getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Integer idCartao) {
		this.idCartao = idCartao;
	}

	public double getLimiteCartao() {
		return limiteCartao;
	}

	public void setLimiteCartao(double limiteCartao) {
		this.limiteCartao = limiteCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate datavalidade) {
		this.dataValidade = datavalidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
