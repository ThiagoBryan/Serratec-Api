package org.serratec.backend.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.biblioteca.dto.LivroDTO;
import org.serratec.backend.biblioteca.exception.ArgumentoInvalidoException;
import org.serratec.backend.biblioteca.exception.LivroException;
import org.serratec.backend.biblioteca.model.Livro;
import org.serratec.backend.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	public LivroDTO modelEmDTO(LivroDTO livroDTO, Livro livro) {

		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDataPublicacao(livro.getDataPublicacao());
		livroDTO.setTipo(livro.getTipo());
		livroDTO.setTitulo(livro.getTitulo());

		return livroDTO;
	}

	public Livro DTOEmModel(LivroDTO livroDTO, Livro livro) {

		livro.setAutor(livroDTO.getAutor());
		livro.setDataPublicacao(livroDTO.getDataPublicacao());
		livro.setTipo(livroDTO.getTipo());
		livro.setTitulo(livroDTO.getTitulo());

		return livro;
	}
	
	public List<LivroDTO> listaLivros(){
		List<Livro> listaModel = livroRepository.findAll();
		List<LivroDTO> listaDTO = new ArrayList<>();
		
		for (Livro livroModel : listaModel) {
			LivroDTO livroDTO = new LivroDTO();
			modelEmDTO(livroDTO, livroModel);
			listaDTO.add(livroDTO);
		}		
		
		return listaDTO;		
	}
	
	public List<LivroDTO> listaOrdenada(String ordem) throws LivroException{
		List<Livro> listaModel = new ArrayList<>();
		List<LivroDTO> listaDTO = new ArrayList<>();
		
		String nomeAtributo = null; 
		
		switch (ordem) { 
		
		case "titulo" :
			nomeAtributo = "titulo";
		break;
		
		case "autor":
			nomeAtributo = "autor";
		break;
		
		case "tipo":
			nomeAtributo = "tipo";
		break;
		
		case "data":
			nomeAtributo = "dataPublicacao";
		break;
		
		default:
			throw new LivroException("Par??metro n??o aceito. Os par??metros aceitos s??o: titulo, autor, categoria, data.");
			
		}
			
		
		listaModel = livroRepository.findAll(Sort.by(Order.by(nomeAtributo)));

		
		for (Livro livroModel : listaModel) {
			LivroDTO livroDTO = new LivroDTO();
			modelEmDTO(livroDTO, livroModel);
			listaDTO.add(livroDTO);
		}		
		
		return listaDTO;		
	}	

	public String salvar(LivroDTO livroDTO) throws ArgumentoInvalidoException {
		if (livroDTO.getTitulo() == null) {
			throw new ArgumentoInvalidoException();
		}
		Livro cliente = new Livro();
		Livro livroSalvar = new Livro();
		livroSalvar = DTOEmModel(livroDTO, cliente);
		livroRepository.save(livroSalvar);
		return "O livro foi criado com o id: " + livroSalvar.getid();
	}

	public LivroDTO buscarPorId(Integer id) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(id);
		Livro buscarLivro = new Livro();
		LivroDTO livroDTO = new LivroDTO();
		if(livro.isPresent()) {
			buscarLivro = livro.get();
			modelEmDTO(livroDTO,buscarLivro);
			return livroDTO;
		}
		throw new LivroException("Livro com o id informado nao encontrado");
	}
	

	public String atualizar(Integer id, LivroDTO livroDTO) throws LivroException {
		// Livro atualizarLivro = livroRepository.findById(id).orElseThrow(LivroException::new);
		Optional<Livro> livro = livroRepository.findById(id);
		Livro atualizarLivro = new Livro();
		if (livro.isPresent()) {
			atualizarLivro = livro.get();
			if (livroDTO.getTitulo() != null) {
				atualizarLivro.setTitulo(livroDTO.getTitulo());
			}
			if (livroDTO.getAutor() != null) {
				atualizarLivro.setAutor(livroDTO.getAutor());
			}
			if (livroDTO.getDataPublicacao() != null) {
				atualizarLivro.setDataPublicacao(livroDTO.getDataPublicacao());
			}
			if (livroDTO.getTipo() != null) {
				atualizarLivro.setTipo(livroDTO.getTipo());
			}
			livroRepository.save(atualizarLivro);
			return "O livro com o id " + atualizarLivro.getid() + " foi atualizado";
		}
		throw new LivroException("Livro nao foi atualizado");
	}

	public void deletar(Integer id) {
		livroRepository.deleteById(id);
	}

	public List<Livro> listarTodos() {
		return livroRepository.findAll();
	}

}
