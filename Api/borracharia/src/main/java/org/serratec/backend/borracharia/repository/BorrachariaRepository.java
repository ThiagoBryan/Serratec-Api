package org.serratec.backend.borracharia.repository;

import java.util.List;

import org.serratec.backend.borracharia.model.Borracharia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BorrachariaRepository extends JpaRepository<Borracharia,Integer> {

	@Query(value="SELECT * FROM borracharia order by borracharia_cd_id DESC",nativeQuery=true)
	List<Borracharia> buscarTodosDesc();
}
