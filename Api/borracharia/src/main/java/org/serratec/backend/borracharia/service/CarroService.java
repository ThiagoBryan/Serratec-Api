package org.serratec.backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.borracharia.DTO.CarroDTO;
import org.serratec.backend.borracharia.exception.CarroException;
import org.serratec.backend.borracharia.model.Carro;
import org.serratec.backend.borracharia.repository.CarroRepository;
import org.serratec.backend.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	public CarroDTO ModelEmDTO(CarroDTO carroDTO, Carro carro) {

		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setAno(carro.getAno());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setIdCliente(carro.getClienteCarro().getIdCliente());
		

		return carroDTO;
	}

	public Carro DTOEmModel(CarroDTO carroDTO, Carro carro) {

		
		carro.setAno(carroDTO.getAno());
		carro.setMarca(carroDTO.getMarca());
		carro.setModelo(carroDTO.getModelo());
	
		

		if(carroDTO.getIdCliente() != null) {
			carro.setClienteCarro(clienteRepository.findById(carroDTO.getIdCliente()).get());
		}

		return carro;
	}

	public String salvar(CarroDTO carroDTO) {

		Carro carroSalvar = new Carro();
		DTOEmModel(carroDTO, carroSalvar);
		carroRepository.save(carroSalvar);
		return "O carro criado foi com o id: " + carroSalvar.getIdCarro();

	}
	
	public CarroDTO buscarPorID(Integer idCarro) throws CarroException {
		Optional<Carro> cliente = carroRepository.findById(idCarro);
		Carro buscarCarro = new Carro();
		CarroDTO carroDTO = new CarroDTO();
		if (cliente.isPresent()) {
			buscarCarro = cliente.get();
			ModelEmDTO(carroDTO, buscarCarro);
			return carroDTO;
		}
		throw new CarroException("Carro com o id informado nao encontrado");
	}
	
	public List<CarroDTO> buscarTodos() {
		List<Carro> listaCarro = carroRepository.findAll();
		List<CarroDTO> listaCarroDTO = new ArrayList<>();

		for (Carro carro : listaCarro) {
			CarroDTO carroDTO = new CarroDTO();
			ModelEmDTO(carroDTO, carro);
			listaCarroDTO.add(carroDTO);
		}

		return listaCarroDTO;
	}
	
	public String atualizar(Integer idCarro, CarroDTO carroDTO) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCarro);
		Carro atualizarCarro = new Carro();
		if (carro.isPresent()) {
			atualizarCarro = carro.get();
			if (carroDTO.getAno() != null) {
				atualizarCarro.setAno(carroDTO.getAno());
			}
			if (carroDTO.getMarca() != null) {
				atualizarCarro.setMarca(carroDTO.getMarca());
			}
			if (carroDTO.getModelo() != null) {
				atualizarCarro.setModelo(carroDTO.getModelo());
			}
			
			carroRepository.save(atualizarCarro);
			return "O carro com o id "+atualizarCarro.getIdCarro()+" foi atualizado";
		}
		throw new CarroException("O carro nao existe");
	}
	
	public void salvarListaCarro(List<CarroDTO> listaCarroDTO) {
		List<Carro> listaCarro = new ArrayList<>();
		for (CarroDTO carroDTO : listaCarroDTO) {
			Carro carro = new Carro();
			DTOEmModel(carroDTO,carro);
			listaCarro.add(carro);
			
		}
		carroRepository.saveAll(listaCarro);
	}
	
	public void deletar(Integer idCarro) {
		carroRepository.deleteById(idCarro);
	}
	
}
