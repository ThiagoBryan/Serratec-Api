package org.serratec.backend.projeto03.service;

import java.util.List;
import java.util.Optional;
import org.serratec.backend.projeto03.dto.ClienteDTO;
import org.serratec.backend.projeto03.model.Cliente;
import org.serratec.backend.projeto03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	// transita os dados
	public ClienteDTO transformarClienteModelEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {

		// não setamos o id pois ele é automatico
		// clienteDTO.setIdCliente(cliente.getId());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());

		return clienteDTO;
	}
	
	public Cliente transformarClienteDTOEmClienteModel(ClienteDTO clienteDTO, Cliente cliente) {
		
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setNome(clienteDTO.getCpf());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());

		return cliente;
	}

	public void salvar(ClienteDTO clienteDTO) {
		// clienteDTO possui os dados
		Cliente cliente = new Cliente();
		Cliente clienteSalvar = new Cliente();
		clienteSalvar = transformarClienteDTOEmClienteModel(clienteDTO, cliente);
		clienteRepository.save(clienteSalvar);
	}

	public ClienteDTO buscarPorId(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		// cliente vazio
		Cliente clienteNoBanco = new Cliente();
		// cliente DTO vazio
		ClienteDTO clienteDTO = new ClienteDTO();

		if (cliente.isPresent()) {
			// cliente vazio recebe cliente no banco
			clienteNoBanco = cliente.get();
			clienteDTO = transformarClienteModelEmClienteDTO(clienteDTO, clienteNoBanco);
		}
		return clienteDTO;
	}

	// ATUALIZAR
	public void atualizar(Integer idCliente, Cliente clienteDTO) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = clienteRepository.getById(idCliente);

		if (cliente.isPresent()) {
			if (clienteDTO.getCpf() != null) {
				clienteNoBanco.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getDataNascimento() != null) {
				clienteNoBanco.setDataNascimento(clienteDTO.getDataNascimento());
			}
			if (clienteDTO.getEmail() != null) {
				clienteNoBanco.setEmail(clienteDTO.getEmail());
			}
			if (clienteDTO.getNome() != null) {
				clienteNoBanco.setNome(clienteDTO.getNome());
			}
			if (clienteDTO.getNumeroTelefone() != null) {
				clienteNoBanco.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}
			clienteRepository.save(clienteNoBanco);
		}
	}

	// DELETAR
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	// RETORNA UMA LISTA
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	// SALVA UMA LISTA
	public void salvarTodos(List<Cliente> listaCliente) {
		clienteRepository.saveAll(listaCliente);
	}

}
