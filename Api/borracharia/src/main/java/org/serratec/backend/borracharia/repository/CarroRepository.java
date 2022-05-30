package org.serratec.backend.borracharia.repository;

import org.serratec.backend.borracharia.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {

}
