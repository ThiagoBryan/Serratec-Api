package org.serratec.backend.borracharia.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	private String login;
	private String senha;
	
	public UsuarioDTO() {
		super();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
