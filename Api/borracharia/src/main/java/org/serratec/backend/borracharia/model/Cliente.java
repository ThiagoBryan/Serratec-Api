package org.serratec.backend.borracharia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome")
	@NotNull
	private String nome;

	@Column(name="cliente_num_cpf")
	@NotNull
	private String cpf;
	
	@Column(name="cliente_num_telefone")
	@NotNull
	private String telefone;
	
	@Column(name="cliente_tx_email")
	@NotNull
	private String email;
	
	
	@OneToMany(mappedBy = "clienteCarro")//cascade = CascadeType.ALL
	private List<Carro> listaCarro;

	public Cliente() {
		super();
	}

	public List<Carro> getListaCarro() {
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
