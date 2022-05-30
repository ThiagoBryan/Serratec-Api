package org.serratec.backend.projeto03.repository;

import java.util.List;

import org.serratec.backend.projeto03.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Integer> {

	@Query(value="SELECT * FROM cartao order by cartao_id DESC",nativeQuery=true)
	List<Cartao> buscarTodosDesc(); // tem q colocar buscarTodosDesc no CartaoService na linha do cartaoRepository.buscarTodosDesc(); 
	
	@Query(value="SELECT C FROM Cartao C Order By idCartao DESC")
	List<Cartao> buscarTodosDescHql(); // tem q colocar buscarTodosDescHql no CartaoService na linha do cartaoRepository.buscarTodosDescHql(); 
}
