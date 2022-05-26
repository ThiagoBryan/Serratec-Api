package org.serratec.backend.biblioteca.repository;

import java.util.Optional;

import org.serratec.backend.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer>{

	

	
	 
	

}
