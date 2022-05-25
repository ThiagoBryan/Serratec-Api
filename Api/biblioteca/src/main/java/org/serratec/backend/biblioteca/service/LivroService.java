package org.serratec.backend.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.biblioteca.dto.LivroDTO;
import org.serratec.backend.biblioteca.exception.ArgumentoInvalidoException;
import org.serratec.backend.biblioteca.exception.LivroException;
import org.serratec.backend.biblioteca.model.Livro;
import org.serratec.backend.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

	public LivroDTO buscarPorTitulo(String titulo) throws LivroException {
		Optional<Livro> livro = livroRepository.findByTitulo(titulo);
		Livro buscarLivro = new Livro();
		LivroDTO novoLivroDTO = new LivroDTO();

		if (livro.isPresent()) {
			buscarLivro = livro.get();
			novoLivroDTO = modelEmDTO(novoLivroDTO, buscarLivro);
		} else {
			if (buscarLivro.getTitulo() == null)
				throw new LivroException(titulo);
		}
		return novoLivroDTO;
	}

	public String atualizar(Integer id, LivroDTO livroDTO) throws NotFoundException {
		Livro atualizarLivro = livroRepository.findById(id).orElseThrow(NotFoundException::new);

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

	public void deletar(Integer id) {
		livroRepository.deleteById(id);
	}

	public List<Livro> listarTodos() {
		return livroRepository.findAll();
	}

}
