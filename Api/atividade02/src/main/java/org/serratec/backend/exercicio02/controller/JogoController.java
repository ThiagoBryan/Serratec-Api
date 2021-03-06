package org.serratec.backend.exercicio02.controller;

import java.util.List;
import org.serratec.backend.exercicio02.model.Jogo;
import org.serratec.backend.exercicio02.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	JogoService jogoService;

	@GetMapping("/lista")
	public List<Jogo> getListaJogo() {
		return jogoService.listaJogo();
	}

	@GetMapping("/lista/{idPosicao}")
	public Jogo getIdJogo(@PathVariable int idPosicao) {
		return jogoService.idJogo(idPosicao);
	}

	@PostMapping("/adicionar")
	public void adicionar(@RequestBody Jogo jogo) {
		jogoService.adicionar(jogo);
	}

	@PutMapping("/editar/{idPosicao}")
	public void editar(@PathVariable int idPosicao, @RequestBody Jogo infoEditada) {
		jogoService.editar(idPosicao, infoEditada);
	}

	@DeleteMapping("/deletar/{idPosicao}")
	public void deletar(@PathVariable int idPosicao) {
		jogoService.deletar(idPosicao);
	}
}
