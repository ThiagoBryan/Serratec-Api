package org.serratec.backend.borracharia.security;

public class UsuarioAuthenticationResponse {

	
	private final String token;

	public String getToken() {
		return token;
	}

	public UsuarioAuthenticationResponse(String token) {
		super();
		this.token = token;
	}
	
}
