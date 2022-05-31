package org.serratec.backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.borracharia.DTO.BorrachariaDTO;
import org.serratec.backend.borracharia.DTO.RelatorioBorrachariaDTO;
import org.serratec.backend.borracharia.exception.BorrachariaException;
import org.serratec.backend.borracharia.exception.EmailException;
import org.serratec.backend.borracharia.model.Borracharia;
import org.serratec.backend.borracharia.repository.BorrachariaRepository;
import org.serratec.backend.borracharia.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrachariaService {
	
	@Autowired
	BorrachariaRepository borrachariaRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;
	
	public BorrachariaDTO ModelEmDTO(BorrachariaDTO borrachariaDTO, Borracharia borracharia) {

		borrachariaDTO.setIdBorracharia(borracharia.getIdBorracharia());
		borrachariaDTO.setData(borracharia.getData());
		borrachariaDTO.setValor(borracharia.getValor());
		borrachariaDTO.setServico(borracharia.getServico());
		

		return borrachariaDTO;
	}
	
	public Borracharia DTOEmModel(BorrachariaDTO borrachariaDTO, Borracharia borracharia) {

		borracharia.setData(borrachariaDTO.getData());
		borracharia.setValor(borrachariaDTO.getValor());
		borracharia.setServico(borrachariaDTO.getServico());
		
		if(borrachariaDTO.getIdCarro() != null) {
			borracharia.setCarroBorracharia(carroRepository.findById(borrachariaDTO.getIdCarro()).get());
	
		}
		return borracharia;
	}
	
	public String salvar(BorrachariaDTO borrachariaDTO) throws EmailException, MessagingException {

		Borracharia borrachariaSalvar = new Borracharia();
		DTOEmModel(borrachariaDTO, borrachariaSalvar);
		borrachariaRepository.save(borrachariaSalvar);
		emailService.emailTeste(borrachariaDTO);
		return "O serviço criado foi com o id: " + borrachariaSalvar.getIdBorracharia();

	}
	
	public BorrachariaDTO buscarPorID(Integer idBorracharia) throws BorrachariaException {
		Optional<Borracharia> borracharia = borrachariaRepository.findById(idBorracharia);
		Borracharia buscarBorracharia = new Borracharia();
		BorrachariaDTO borrachariaDTO = new BorrachariaDTO();
		if (borracharia.isPresent()) {
			buscarBorracharia = borracharia.get();
			ModelEmDTO(borrachariaDTO, buscarBorracharia);
			return borrachariaDTO;
		}
		throw new BorrachariaException("Serviço com o id informado nao encontrado");
	}
	
	public List<BorrachariaDTO> buscarTodos() {
		List<Borracharia> listaBorracharia = borrachariaRepository.findAll();
		List<BorrachariaDTO> listaBorrachariaDTO = new ArrayList<>();

		for (Borracharia borracharia : listaBorracharia) {
			BorrachariaDTO borrachariaDTO = new BorrachariaDTO();
			ModelEmDTO(borrachariaDTO, borracharia);
			listaBorrachariaDTO.add(borrachariaDTO);
		}

		return listaBorrachariaDTO;
	}
	
	public String atualizar(Integer idBorracharia, BorrachariaDTO borrachariaDTO) throws BorrachariaException {
		Optional<Borracharia> borracharia = borrachariaRepository.findById(idBorracharia);
		 Borracharia atualizarborracharia = new  Borracharia();
		if (borracharia.isPresent()) {
			atualizarborracharia = borracharia.get();
			if (borrachariaDTO.getData() != null) {
				atualizarborracharia.setData(borrachariaDTO.getData());
			}
			if (borrachariaDTO.getValor() != 0) {
				atualizarborracharia.setValor(borrachariaDTO.getValor());
			}
			borrachariaRepository.save(atualizarborracharia);
			return "O serviço com o id "+atualizarborracharia.getIdBorracharia()+" foi atualizado";
		}
		throw new BorrachariaException("O serviço nao existe");
	}
	
	public void salvarListaCarro(List<BorrachariaDTO> listaBorrachariaDTO) {
		List<Borracharia> listaBorracharia = new ArrayList<>();
		for (BorrachariaDTO borrachariaDTO : listaBorrachariaDTO) {
			Borracharia borracharia = new Borracharia();
			DTOEmModel(borrachariaDTO,borracharia);
			listaBorracharia.add(borracharia);
			
		}
		borrachariaRepository.saveAll(listaBorracharia);
	}
	
	public void deletar(Integer idBorracharia) {
		borrachariaRepository.deleteById(idBorracharia);
	}
	
	public List<RelatorioBorrachariaDTO> relatorio() {
		return borrachariaRepository.relatorio();
	}
	

}
