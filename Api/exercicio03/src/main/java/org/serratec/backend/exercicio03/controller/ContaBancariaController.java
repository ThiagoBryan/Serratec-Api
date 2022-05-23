package org.serratec.backend.exercicio03.controller;

import java.util.List;

import org.serratec.backend.exercicio03.model.ContaBancaria;
import org.serratec.backend.exercicio03.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contaBancaria")
public class ContaBancariaController {
	
	@Autowired
	ContaBancariaService contaBancariaService;

	@PostMapping("/conta")
	public ResponseEntity<Void> salvar(@RequestBody ContaBancaria contaBancaria) {
		contaBancariaService.salvar(contaBancaria);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ContaBancaria>> listaTodos(){
		return ResponseEntity.ok(contaBancariaService.listarTodos());
	}
	
	
	@GetMapping("/buscar/{idNumeroConta}")
	public ResponseEntity<ContaBancaria> getContaBancariaById(@PathVariable int idNumeroConta) {
		return ResponseEntity.ok(contaBancariaService.buscarPorNumeroConta(idNumeroConta));
	}
	
//	@DeleteMapping("/deletar/{numeroContaPosicao}")
//	public void deletar(@PathVariable int numeroContaPosicao) {
//		contaBancariaService.deletar(numeroContaPosicao);
//	}
	
}
