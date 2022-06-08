package org.serratec.backend.borracharia.repository;

import java.util.Optional;

import org.serratec.backend.borracharia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	@Query(value="FROM Usuario u WHERE u.login = ?1")
	Optional<Usuario> buscarPorLogin(String login);
}
