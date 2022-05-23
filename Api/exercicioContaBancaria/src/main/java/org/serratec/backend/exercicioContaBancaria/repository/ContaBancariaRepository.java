package org.serratec.backend.exercicioContaBancaria.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.exercicioContaBancaria.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria,Integer> {

	Optional<ContaBancaria> findByNumeroConta(Integer numeroConta);

	@Transactional
	Optional<ContaBancaria> deleteByNumeroConta(Integer numeroConta);

	ContaBancaria getByNumeroConta(Integer numeroConta);

}
