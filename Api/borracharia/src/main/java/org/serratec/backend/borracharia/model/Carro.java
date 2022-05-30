package org.serratec.backend.borracharia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="carro")
public class Carro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="carro_cd_id")
	private Integer idCarro;
	
	@Column(name="carro_tx_modelo")
	@NotNull
	private String modelo;
	
	@Column(name="carro_tx_marca")
	@NotNull
	private String marca;
	
	@Column(name="carro_num_ano")
	@NotNull
	private Integer ano;
	
	
	

	@OneToMany(mappedBy = "clienteBorracharia")//cascade = CascadeType.ALL
	private List<Borracharia> listaBorracharia;
	
	
	public List<Borracharia> getListaBorracharia() {
		return listaBorracharia;
	}

	public void setListaBorracharia(List<Borracharia> listaBorracharia) {
		this.listaBorracharia = listaBorracharia;
	}

	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_cd_id")
	@JsonIgnore
	private Cliente clienteCarro;

	public Cliente getClienteCarro() {
		return clienteCarro;
	}

	public void setClienteCarro(Cliente clienteCarro) {
		this.clienteCarro = clienteCarro;
	}

	public Carro() {
		super();
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
