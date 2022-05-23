package org.serratec.backend.projeto03.controller;

import java.util.List;

import org.serratec.backend.projeto03.model.Cliente;
import org.serratec.backend.projeto03.service.ClienteService;
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
	public class ClienteControler {

		@Autowired //instancia automaticamente um objeto
		ClienteService clienteService;

		@PostMapping("/salvar")				//@RequestBody dados necessarios para salvar um cliente
		public ResponseEntity<Void> salvar(@RequestBody Cliente cliente) {
			clienteService.salvar(cliente);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}				//resposta que esta devolvendo
		
		@GetMapping("/buscar/{idCliente}")			//@PathVariable informação na URL
		public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer idCliente){
			return  ResponseEntity.ok(clienteService.buscarPorId(idCliente));
		}
	
		@PutMapping("/atualizar/{idCliente}")
		public ResponseEntity<Void> atualizar(@PathVariable Integer idCliente,@RequestBody Cliente cliente){
			clienteService.atualizar(idCliente, cliente);
			return new  ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/delete/{idCliente}")
		public  ResponseEntity<Void> delete(@PathVariable Integer idCliente) {
			clienteService.delete(idCliente);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/lista")
		public ResponseEntity<List<Cliente>> listaTodos(){
			return ResponseEntity.ok(clienteService.listarTodos());
		}
		
		@PostMapping("/salvar-lista")
		public ResponseEntity<Void> salvarLista(@RequestBody List<Cliente> listaCliente) {
			clienteService.salvarTodos(listaCliente);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}


	}

	
	
	
	
	
	
	