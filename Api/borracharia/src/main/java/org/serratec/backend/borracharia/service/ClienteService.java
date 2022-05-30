package org.serratec.backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.borracharia.DTO.ClienteDTO;
import org.serratec.backend.borracharia.exception.ClienteException;
import org.serratec.backend.borracharia.model.Cliente;
import org.serratec.backend.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteDTO ModelEmDTO(ClienteDTO clienteDTO, Cliente cliente) {

		clienteDTO.setId(cliente.getIdCliente());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setTelefone(cliente.getTelefone());
		clienteDTO.setEmail(cliente.getEmail());

		return clienteDTO;

	}

	public Cliente DTOEmModel(ClienteDTO clienteDTO, Cliente cliente) {

		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setTelefone(clienteDTO.getTelefone());
		cliente.setEmail(clienteDTO.getEmail());

		return cliente;
	}

	public String salvar(ClienteDTO clienteDTO) {

		Cliente clienteSalvar = new Cliente();
		DTOEmModel(clienteDTO, clienteSalvar);
		clienteRepository.save(clienteSalvar);
		return "O cliente criado foi com o id: " + clienteSalvar.getIdCliente();

	}

	public ClienteDTO buscarPorID(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente buscarCliente = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		if (cliente.isPresent()) {
			buscarCliente = cliente.get();
			ModelEmDTO(clienteDTO, buscarCliente);
			return clienteDTO;
		}
		throw new ClienteException("Cliente com o id informado nao encontrado");

	}

	public List<ClienteDTO> buscarTodos() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ClienteDTO> listaCartaoDTO = new ArrayList<>();

		for (Cliente cartao : listaCliente) {
			ClienteDTO cartaoDTO = new ClienteDTO();
			ModelEmDTO(cartaoDTO, cartao);
			listaCartaoDTO.add(cartaoDTO);
		}

		return listaCartaoDTO;
	}

	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente atualizarCliente = new Cliente();
		if (cliente.isPresent()) {
			atualizarCliente = cliente.get();
			if (clienteDTO.getCpf() != null) {
				atualizarCliente.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getNome() != null) {
				atualizarCliente.setNome(atualizarCliente.getNome());
			}
			if (clienteDTO.getEmail() != null) {
				atualizarCliente.setEmail(atualizarCliente.getEmail());
			}
			if (clienteDTO.getTelefone() != null) {
				atualizarCliente.setTelefone(atualizarCliente.getTelefone());
			}
			clienteRepository.save(atualizarCliente);
			return "O cliente com o id "+atualizarCliente.getIdCliente()+" foi atualizado";
		}
		throw new ClienteException("O cliente nao existe");
	}
	
	public void salvarListaCliente(List<ClienteDTO> listaClienteDTO) {
		List<Cliente> listaCliente = new ArrayList<>();
		for (ClienteDTO clienteDTO : listaClienteDTO) {
			Cliente cliente = new Cliente();
			DTOEmModel(clienteDTO,cliente);
			listaCliente.add(cliente);
			
		}
		clienteRepository.saveAll(listaCliente);
	}
	
	public void deletar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
}
