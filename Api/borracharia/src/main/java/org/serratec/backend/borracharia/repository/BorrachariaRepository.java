package org.serratec.backend.borracharia.repository;

import java.util.List;

import org.serratec.backend.borracharia.DTO.RelatorioBorrachariaDTO;
import org.serratec.backend.borracharia.model.Borracharia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BorrachariaRepository extends JpaRepository<Borracharia,Integer> {
	
	
	@Query(value="select\r\n"
			+ "c2.CLIENTE_TX_NOME as cliente,\r\n"
			+ "c.CARRO_TX_MODELO as modelo,\r\n"
			+ "b.BORRACHARIA_TX_SERVICO as servico,\r\n"
			+ "b.BORRACHARIA_NUM_VALOR as valor\r\n"
			+ "from borracharia b join carro c on(b.BORRACHARIA_TX_SERVICO=c.CARRO_CD_ID )\r\n"
			+ "join cliente c2 on(c2.CLIENTE_CD_ID=c.CLIENTE_ID)\r\n"
			+ "order by b.BORRACHARIA_CD_ID desc\r\n"
			+ "limit 5", nativeQuery=true)
	
	List<RelatorioBorrachariaDTO> relatorio();

}
