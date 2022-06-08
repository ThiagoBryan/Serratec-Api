package org.serratec.backend.projetoFinal.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.serratec.backend.projetoFinal.model.Endereco;

public class ClienteDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	//private List<Endereco> listaEndereco;
	private String telefonePrincipal;
	private String telefoneSecundario;
	
	public ClienteDTO() {
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

//	public List<Endereco> getListaEndereco() {
//		return listaEndereco;
//	}
//
//	public void setListaEndereco(List<Endereco> listaEndereco) {
//		this.listaEndereco = listaEndereco;
//	}
	
	
	
	
}
