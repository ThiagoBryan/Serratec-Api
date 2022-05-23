package org.serratec.backend.exercicioContaBancaria.service;

import org.serratec.backend.exercicioContaBancaria.exception.ArgumentoInvalidoException;
import org.serratec.backend.exercicioContaBancaria.exception.SaldoInsuficienteException;
import org.serratec.backend.exercicioContaBancaria.model.ContaBancaria;
import org.serratec.backend.exercicioContaBancaria.model.Operacao;
import org.serratec.backend.exercicioContaBancaria.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {

	@Autowired
	ContaBancariaRepository contaBancariaRepository;

	public void escolhaOperacao(Integer numeroConta, Operacao operacao)
			throws SaldoInsuficienteException, ArgumentoInvalidoException {
		ContaBancaria conta = contaBancariaRepository.getByNumeroConta(numeroConta);
		if (operacao.getTipo().equalsIgnoreCase("débito")) {
			conta.setSaldo(conta.getSaldo() + operacao.getValor());
		} else if (operacao.getTipo().equalsIgnoreCase("crédito")) {
			if (conta.getSaldo() < operacao.getValor()) {
				throw new SaldoInsuficienteException("SALDO INSUFICIENTE");
			} else {
				conta.setSaldo(conta.getSaldo() - operacao.getValor());
			}
		} else {
			throw new ArgumentoInvalidoException("OPÇÃO INVÁLIDA");
		}
		contaBancariaRepository.save(conta);
	}

}
