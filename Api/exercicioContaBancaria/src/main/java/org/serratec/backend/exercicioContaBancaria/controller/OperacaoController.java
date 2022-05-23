package org.serratec.backend.exercicioContaBancaria.controller;

import org.serratec.backend.exercicioContaBancaria.exception.ArgumentoInvalidoException;
import org.serratec.backend.exercicioContaBancaria.exception.SaldoInsuficienteException;
import org.serratec.backend.exercicioContaBancaria.model.Operacao;
import org.serratec.backend.exercicioContaBancaria.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {
	
	@Autowired
	OperacaoService operacaoService;

	@PutMapping("/conta/{numeroConta}")
	public ResponseEntity<Void> escolhaOperacao(@PathVariable Integer numeroConta,@RequestBody Operacao operacao) throws SaldoInsuficienteException, ArgumentoInvalidoException{
		operacaoService.escolhaOperacao(numeroConta, operacao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
