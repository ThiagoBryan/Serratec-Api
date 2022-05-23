package org.serratec.backend.exercicioContaBancaria.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.exercicioContaBancaria.exception.SaldoInsuficienteException;
import org.serratec.backend.exercicioContaBancaria.model.ContaBancaria;
import org.serratec.backend.exercicioContaBancaria.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {

	@Autowired
	ContaBancariaRepository contaBancariaRepository;

	public void salvar(ContaBancaria contaBancaria) {
		contaBancariaRepository.save(contaBancaria);
	}

	public List<ContaBancaria> listarTodos() {
		return contaBancariaRepository.findAll();
	}

	public ContaBancaria buscarPorNumeroConta(Integer numeroConta) {
		Optional<ContaBancaria> contaBancaria = contaBancariaRepository.findByNumeroConta(numeroConta);
		ContaBancaria conta = new ContaBancaria();
		if (contaBancaria.isPresent()) {
			conta = contaBancaria.get();
		}
		return conta;
	}

	public void atualizar(Integer numeroConta, ContaBancaria contaBancaria) {
		ContaBancaria conta = buscarPorNumeroConta(numeroConta);

		if (contaBancaria.getNumeroConta() != null) {
			conta.setNumeroConta(contaBancaria.getNumeroConta());
		}

		if (contaBancaria.getTitular() != null) {
			conta.setTitular(contaBancaria.getTitular());

		}
		contaBancariaRepository.save(conta);
	}

	public void delete(Integer numeroConta) {
		contaBancariaRepository.deleteByNumeroConta(numeroConta);
	}

	public void depositar(Integer numeroConta, double valor) {
		ContaBancaria conta = buscarPorNumeroConta(numeroConta);

		conta.setSaldo(conta.getSaldo() + valor);

		contaBancariaRepository.save(conta);
	}

	public void sacar(Integer numeroConta, double valor) throws SaldoInsuficienteException {
		ContaBancaria conta = buscarPorNumeroConta(numeroConta);

		if (conta.getSaldo() < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} else {
			conta.setSaldo(conta.getSaldo() - valor);

			contaBancariaRepository.save(conta);
		}

	}
}