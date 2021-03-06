package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import org.serratec.backend.projetoFinal.DTO.EnderecoDTO;
import org.serratec.backend.projetoFinal.exception.EnderecoException;
import org.serratec.backend.projetoFinal.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody EnderecoDTO enderecoDTO) {
		return ResponseEntity.ok(enderecoService.salvar(enderecoDTO));
	}
	
	@GetMapping("/buscar/{idEndereco}")
	public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Integer idEndereco) throws EnderecoException{
		return ResponseEntity.ok(enderecoService.buscarPorId(idEndereco));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<EnderecoDTO>> listarTodos(){
		return ResponseEntity.ok(enderecoService.buscarTodos());
	}
	
	@PutMapping("/atualizar/{idEndereco}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idEndereco, @RequestBody EnderecoDTO enderecoDTO) throws EnderecoException{
		return ResponseEntity.ok(enderecoService.atualizar(idEndereco, enderecoDTO));
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<EnderecoDTO> listaCartaoDTO){
		enderecoService.salvarListaEndereco(listaCartaoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idEndereco}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idEndereco){
		enderecoService.deletar(idEndereco);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
