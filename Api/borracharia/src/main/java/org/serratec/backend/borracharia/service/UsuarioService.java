package org.serratec.backend.borracharia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.borracharia.DTO.UsuarioDTO;
import org.serratec.backend.borracharia.model.Usuario;
import org.serratec.backend.borracharia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UsuarioDTO mapToDTO(UsuarioDTO usuarioDTO, Usuario usuario) {
		
		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setLogin(usuario.getLogin());
		usuarioDTO.setSenha(usuario.getSenha());
		
		return usuarioDTO;
		
	}
	
	public Usuario mapToModel(UsuarioDTO usuarioDTO, Usuario usuario) {
		
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
		
		return usuario;
	}

	public Integer salvar(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		mapToModel(usuarioDTO,usuario);
		usuarioRepository.save(usuario);
		return usuario.getIdUsuario();
	}
	
	public UsuarioDTO buscar(Integer idUsuario) {
		return usuarioRepository.findById(idUsuario)
				.map(usuario -> mapToDTO(new UsuarioDTO(),usuario))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<UsuarioDTO> buscarTodos(){
		return usuarioRepository.findAll()
				.stream()
				.map(usuario -> mapToDTO( new UsuarioDTO(),usuario))
				.collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorLogin(String Username) {
		return usuarioRepository.findAll()
				.stream()
				.filter(usuario -> usuario.getLogin().equals(Username))
				.map(usuario -> mapToDTO( new UsuarioDTO(),usuario))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
				
	}

	
}
