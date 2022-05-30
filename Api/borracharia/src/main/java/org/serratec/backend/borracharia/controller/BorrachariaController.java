package org.serratec.backend.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.borracharia.DTO.BorrachariaDTO;
import org.serratec.backend.borracharia.DTO.CarroDTO;
import org.serratec.backend.borracharia.exception.BorrachariaException;
import org.serratec.backend.borracharia.exception.CarroException;
import org.serratec.backend.borracharia.exception.EmailException;
import org.serratec.backend.borracharia.service.BorrachariaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borracharia")
public class BorrachariaController {
	
	@Autowired
	BorrachariaService borrachariaService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody BorrachariaDTO borrachariaDTO) throws EmailException, MessagingException{
		return ResponseEntity.ok(borrachariaService.salvar(borrachariaDTO));
		
	}
	
	@GetMapping("/buscar/{idBorracharia}")
	public ResponseEntity<BorrachariaDTO> buscarPorId(@PathVariable Integer idBorracharia) throws BorrachariaException{
		return ResponseEntity.ok(borrachariaService.buscarPorID(idBorracharia));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<BorrachariaDTO>> listarTodos(){
		return ResponseEntity.ok(borrachariaService.buscarTodos());
	}
	
	@PutMapping("/atualizar/{idBorracharia}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idBorracharia, @RequestBody BorrachariaDTO borrachariaDTO) throws BorrachariaException{
		return ResponseEntity.ok(borrachariaService.atualizar(idBorracharia, borrachariaDTO));
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<BorrachariaDTO> listaBorrachariaDTO){
		borrachariaService.salvarListaCarro(listaBorrachariaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idBorracharia}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idBorracharia){
		borrachariaService.deletar(idBorracharia);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	

}
