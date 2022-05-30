package org.serratec.backend.projeto03.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //para saber que tem uma tabela
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_cd_id") //cd para identificar o que no caso cd = id
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome") //tx para identificar o que no caso tx = id
	private String nome;
	
	@Column(name="cliente_tx_cpf") //tx para identificar o que no caso tx = id
	private String cpf;
	
	@Column(name="cliente_tx_numeroTelefone") //tx para identificar o que no caso tx = id
	private String numeroTelefone;
	
	@Column(name="cliente_tx_email") //tx para identificar o que no caso tx = id
	private String email;
	
	@Column(name="cliente_dt_dataNascimento") //dt para identificar o que no caso dt = id
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "cliente") //PARA LIGAR AS CLASSES E SEMPRE CRIAR OS GETTERS AND SETTERS
	private List<Cartao> listaCartao;

	
	// GETTERS AND SETTERS do @onetomany
	

	public List<Cartao> getListaCartao() {
		return listaCartao;
	}

	public void setListaCartao(List<Cartao> listaCartao) {
		this.listaCartao = listaCartao;
	}

	//CONSTRUTOR
	public Cliente() {
		
	}
	
	// GETTERS AND SETTERS
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
