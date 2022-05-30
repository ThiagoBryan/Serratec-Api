package org.serratec.backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.mail.MessagingException;
import org.serratec.backend.projeto03.dto.CartaoDTO;
import org.serratec.backend.projeto03.exception.CartaoException;
import org.serratec.backend.projeto03.exception.EmailException;
import org.serratec.backend.projeto03.model.Cartao;
import org.serratec.backend.projeto03.repository.CartaoRepository;
import org.serratec.backend.projeto03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
	
	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired
	EmailService emailService;
	
	
	public CartaoDTO transformarModelEmDTO(Cartao cartao, CartaoDTO cartaoDTO) {
		
		cartaoDTO.setIdCartao(cartao.getIdCartao());
		cartaoDTO.setDataValidade(cartao.getDataValidade());
		cartaoDTO.setLimiteCartao(cartao.getLimiteCartao());
		cartaoDTO.setNomeTitular(cartao.getNomeTitular());
		cartaoDTO.setNumeroCartao(cartao.getNumeroCartao());
		
		return cartaoDTO;
	}
	
	public Cartao transformarDTOEmModel(Cartao cartao, CartaoDTO cartaoDTO) {
		
		// não setamos o id pois ele é automatico
		cartao.setDataValidade(cartaoDTO.getDataValidade());
		cartao.setLimiteCartao(cartaoDTO.getLimiteCartao());
		cartao.setNomeTitular(cartaoDTO.getNomeTitular());
		cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
		
		if(cartaoDTO.getIdCliente() != null) { //PARA LIGAR AS CLASSES
			cartao.setCliente(clienteRepository.findById(cartaoDTO.getIdCliente()).get());
			
		}
		return cartao;
		
	}
	
	public String salvar(CartaoDTO cartaoDTO) throws EmailException, MessagingException {
		Cartao cartao = new Cartao();
		transformarDTOEmModel(cartao,cartaoDTO);
		cartaoRepository.save(cartao);
		emailService.emailTeste(cartaoDTO);// enviar e-mail quando salvar o cartao
		return "O cartao criado foi com o id: "+cartao.getIdCartao();
	}
	
	public CartaoDTO buscarPorId(Integer idCartao) throws CartaoException {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		Cartao cartaoNoBanco = new Cartao();
		CartaoDTO cartaoDTO = new CartaoDTO();
		if(cartao.isPresent()) {
			cartaoNoBanco = cartao.get();
			transformarModelEmDTO(cartaoNoBanco,cartaoDTO);
			return cartaoDTO;
		}
		throw new CartaoException("Cartao com o id informado nao encontrado");
	}
	
	public void deletar(Integer idCartao) {
		cartaoRepository.deleteById(idCartao);
	}
	
	public String atualizar(Integer idCartao,CartaoDTO cartaoDTO) throws CartaoException {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		Cartao cartaoBanco = new Cartao();
		if (cartao.isPresent()) {
			cartaoBanco = cartao.get();
			if (cartaoDTO.getDataValidade() != null) {
				cartaoBanco.setDataValidade(cartaoDTO.getDataValidade());
			}
			if (cartaoDTO.getLimiteCartao() != 0) {
				cartaoBanco.setLimiteCartao(cartaoDTO.getLimiteCartao());
			}
			if (cartaoDTO.getNomeTitular() != null) {
				cartaoBanco.setNomeTitular(cartaoDTO.getNomeTitular());
			}
			if (cartaoDTO.getNumeroCartao() != null) {
				cartaoBanco.setNumeroCartao(cartaoDTO.getNumeroCartao());
			}
			cartaoRepository.save(cartaoBanco);
			return "O cartao com o id "+cartaoBanco.getIdCartao()+" foi atualizado";
		}
		throw new CartaoException("O cartao nao foi atualizado");
	}
	
	public List<CartaoDTO> buscarTodos(){				//para usar sem ser DESC so trocar por findAll();
		List<Cartao> listaCartaoModel = cartaoRepository.findAll();
		List<CartaoDTO> listaCartaoDTO = new ArrayList<>();
		
		for (Cartao cartao : listaCartaoModel) {
			CartaoDTO cartaoDTO = new CartaoDTO();
			transformarModelEmDTO(cartao,cartaoDTO);
			listaCartaoDTO.add(cartaoDTO);
		}
		
		return listaCartaoDTO;
	}
	
	
	public void salvarListaCartao(List<CartaoDTO> listaCartaoDTO) {
		List<Cartao> listaCartao = new ArrayList<>();
		for (CartaoDTO cartaoDTO : listaCartaoDTO) {
			Cartao cartao = new Cartao();
			transformarDTOEmModel(cartao,cartaoDTO);
			listaCartao.add(cartao);
			
		}
		cartaoRepository.saveAll(listaCartao);
	}

}
