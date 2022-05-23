package org.serratec.backend.projeto02.controller;

import java.util.List;

import org.serratec.backend.projeto02.model.Todo;
import org.serratec.backend.projeto02.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // SEMPRE QUE CRIAR O CONTROLLER TEM QUE TER ESSA ANOTAÇÃO
@RequestMapping("/todo")// CRIA O ENDPOINT;
public class TodoController {
	
	@Autowired// PARA INSTANCIAR O SERVICE; 
	TodoService todoService;
	
	@GetMapping("/lista") //CRIA O ENDPOINT PARA O GET;
	public List<Todo> getTodo(){ 
		return todoService.listaTodo(); // PEGA A LISTA CRIADA NO SERVICE;
	}
	
	@PostMapping("/adicionar") //CRIA O ENDPOINT PARA O POST;
	public void adicionar(@RequestBody Todo todo) { // REQUESTBODY PEGA O BODY DA CLASSE;
		todoService.adicionar(todo);
	}
	
	@PutMapping("/atualizar") //CRIA O ENDPOINT PARA O PUT;
	public void atualizar(@RequestParam Integer idTodo, @RequestBody Todo todoApi) {
		todoService.atualizar(idTodo, todoApi);
		
	}	
	//OUTRA FORMA DE FAZER O ATUALIZAR

//O @PathVariable é utilizado sempre para id
//	@PutMapping("/atualizar/{idTodo}")
//	public void atualizar(@PathVariable Integer idTodo, @RequestBody Todo todoApi) {
//		todoService.atualizar(idTodo, todoApi);
//		}
	
	@DeleteMapping("/delete/{idTodo}") //CRIA O ENDPOINT PARA O DELETE;
	public void deletar(@PathVariable int idTodo) {//O @PathVariable é utilizado sempre para id
		todoService.deletar(idTodo);
	}
}
