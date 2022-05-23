package org.serratec.backend.exercicio03.repository;

import java.util.Optional;

import org.serratec.backend.exercicio03.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria,Integer> {

	Optional<ContaBancaria> findByNumeroConta(Integer idNumeroConta);

}
