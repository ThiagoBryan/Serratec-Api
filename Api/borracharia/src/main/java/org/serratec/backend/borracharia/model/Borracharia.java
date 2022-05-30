package org.serratec.backend.borracharia.model;

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
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="borracharia")
public class Borracharia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="borracharia_cd_id")
	private Integer idBorracharia;
	
	@Column(name="borracharia_num_valor")
	@NotNull
	private double valor;
	
	@Column(name="borracharia_tx_servico")
	@NotNull
	private String servico;
	
	@Column(name="borracharia_dt_data")
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "carro_cd_id")
	@JsonIgnore
	private Carro clienteBorracharia;

	public Carro getClienteBorracharia() {
		return clienteBorracharia;
	}

	public void setClienteBorracharia(Carro clienteBorracharia) {
		this.clienteBorracharia = clienteBorracharia;
	}

	public Borracharia() {
		super();
	}

	public Integer getIdBorracharia() {
		return idBorracharia;
	}

	public void setIdBorracharia(Integer idBorracharia) {
		this.idBorracharia = idBorracharia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
