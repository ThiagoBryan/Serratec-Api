package org.serratec.backend.borracharia.controller;

import javax.validation.Valid;

import org.serratec.backend.borracharia.DTO.UsuarioDTO;
import org.serratec.backend.borracharia.security.JwtUtil;
import org.serratec.backend.borracharia.security.UsuarioAuthenticationRequest;
import org.serratec.backend.borracharia.security.UsuarioAuthenticationResponse;
import org.serratec.backend.borracharia.security.UsuarioDetalheService;
import org.serratec.backend.borracharia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioDetalheService usuarioDetalheService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	

	
	@PostMapping("/salvar")
	public ResponseEntity<Integer> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO){
		return ResponseEntity.ok(usuarioService.salvar(usuarioDTO));
		
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<UsuarioDTO> buscar(@RequestParam String login){
		return ResponseEntity.ok(usuarioService.buscarPorLogin(login));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> criarAutenticacao(@RequestBody UsuarioAuthenticationRequest usuario) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
		}catch(Exception e){
			throw new Exception("Senha incorreta",e);
		}
UserDetails usuarioDetalhe = usuarioDetalheService.loadUserByUsername(usuario.getUsername());
		String token = jwtUtil.generateToken(usuarioDetalhe);
		return ResponseEntity.ok(new UsuarioAuthenticationResponse(token));
	}

	
}
