package org.serratec.backend.exercicioContaBancaria.controller;

import java.util.List;

import org.serratec.backend.exercicioContaBancaria.exception.SaldoInsuficienteException;
import org.serratec.backend.exercicioContaBancaria.model.ContaBancaria;
import org.serratec.backend.exercicioContaBancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaBancariaController {

	@Autowired
	ContaBancariaService contaBancariaService;

	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody ContaBancaria contaBancaria) {
		contaBancariaService.salvar(contaBancaria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ContaBancaria>> listaTodos(){
		return ResponseEntity.ok(contaBancariaService.listarTodos());
	}
	
	@GetMapping("/buscar/{numeroConta}")
	public ResponseEntity<ContaBancaria> getContaBancariaById(@PathVariable int numeroConta) {
		return ResponseEntity.ok(contaBancariaService.buscarPorNumeroConta(numeroConta));
	}
	
	@PutMapping("/atualizar/{numeroConta}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer numeroConta,@RequestBody ContaBancaria conta){
		contaBancariaService.atualizar(numeroConta, conta);
		return new  ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/depositar/{numeroConta}")
	public ResponseEntity<Void> depositar(@PathVariable Integer numeroConta,@RequestParam double valor){
		contaBancariaService.depositar(numeroConta, valor);
		return new  ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/sacar/{numeroConta}")
	public ResponseEntity<Void> sacar(@PathVariable Integer numeroConta,@RequestParam double valor) throws SaldoInsuficienteException{
		contaBancariaService.sacar(numeroConta, valor);
		return new  ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/delete/{numeroConta}")
	public ResponseEntity<Void> delete(@PathVariable Integer numeroConta) {
		contaBancariaService.delete(numeroConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	}

