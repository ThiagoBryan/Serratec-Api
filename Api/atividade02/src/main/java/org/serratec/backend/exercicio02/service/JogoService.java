package org.serratec.backend.exercicio02.service;

import java.util.ArrayList;
import java.util.List;
import org.serratec.backend.exercicio02.model.Jogo;
import org.springframework.stereotype.Service;


@Service
public class JogoService {
		
	public List<Jogo> jogo = new ArrayList<>();	

	public List<Jogo> listaJogo() {
		return this.jogo;
	}
	
	public Jogo idJogo(int idPosicao) {			
		Jogo jogoEscolhido = new Jogo();
		for (Jogo banana : jogo) {
			if(banana.getId().equals(idPosicao)) { // for each para pesquisar pelo id
				jogoEscolhido = banana;
			}
		}
//		jogoEscolhido = jogo.get(idPosicao);		
		return jogoEscolhido;
		
	}

	
	public void adicionar(Jogo livro) {
		jogo.add(livro);
	}
	
	public void editar(int idPosicao, Jogo infoEditada) {
		Jogo livroEditado = jogo.get(idPosicao);
		
		livroEditado.setId(infoEditada.getId());
		livroEditado.setTitulo(infoEditada.getTitulo());
		livroEditado.setEmpresa(infoEditada.getEmpresa());
	}
	
	public void deletar(int idPosicao) {
		jogo.remove(idPosicao);
	}

}
