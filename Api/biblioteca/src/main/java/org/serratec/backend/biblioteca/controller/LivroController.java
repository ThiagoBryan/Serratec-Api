package org.serratec.backend.biblioteca.controller;

import java.util.List;

import org.serratec.backend.biblioteca.dto.LivroDTO;
import org.serratec.backend.biblioteca.exception.ArgumentoInvalidoException;
import org.serratec.backend.biblioteca.exception.LivroException;
import org.serratec.backend.biblioteca.model.Livro;
import org.serratec.backend.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody LivroDTO livroDTO) throws ArgumentoInvalidoException{
		return ResponseEntity.ok(livroService.salvar(livroDTO));
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Integer id) throws LivroException {
		return ResponseEntity.ok(livroService.buscarPorId(id));
	}
	
	@GetMapping("/lista/ordenada")
	public ResponseEntity<List<LivroDTO>> listaOrdenada(@RequestParam String ordem) throws LivroException {
		return ResponseEntity.ok(livroService.listaOrdenada(ordem));
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Integer id,@RequestBody LivroDTO livroDTO) throws NotFoundException, LivroException{
		return ResponseEntity.ok(livroService.atualizar(id, livroDTO));
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		livroService.deletar(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Livro>>listaTodos(){
		return ResponseEntity.ok(livroService.listarTodos());
	}
}
