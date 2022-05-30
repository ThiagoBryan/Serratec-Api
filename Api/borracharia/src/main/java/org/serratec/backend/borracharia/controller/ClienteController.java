package org.serratec.backend.borracharia.controller;

import java.util.List;

import org.serratec.backend.borracharia.DTO.ClienteDTO;
import org.serratec.backend.borracharia.exception.ClienteException;
import org.serratec.backend.borracharia.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO){
		return ResponseEntity.ok(clienteService.salvar(clienteDTO));
		
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
		return ResponseEntity.ok(clienteService.buscarPorID(idCliente));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ClienteDTO>> listarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@PutMapping("/atualizar/{idCliente}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO) throws ClienteException{
		return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<ClienteDTO> listaClienteDTO){
		clienteService.salvarListaCliente(listaClienteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCliente){
		clienteService.deletar(idCliente);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	

	

}
