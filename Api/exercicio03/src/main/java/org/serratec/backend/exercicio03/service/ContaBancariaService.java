package org.serratec.backend.exercicio03.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.exercicio03.model.ContaBancaria;
import org.serratec.backend.exercicio03.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {

	
	@Autowired
	ContaBancariaRepository contaBancariaRepository;
	
	
	public void salvar(ContaBancaria contaBancaria) {
		contaBancariaRepository.save(contaBancaria);
	}
	
	
	public List<ContaBancaria> listarTodos(){
		return contaBancariaRepository.findAll();
	}
	
	
	
	public ContaBancaria buscarPorNumeroConta(Integer idNumeroConta) {
		Optional<ContaBancaria> contaBancaria = contaBancariaRepository.findByNumeroConta(idNumeroConta);
		ContaBancaria conta = new ContaBancaria();
		if(contaBancaria.isPresent()) {	
			conta = contaBancaria.get();
		}
		return conta;
	}
	

}
