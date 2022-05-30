package org.serratec.backend.projetoFinal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.DTO.ClienteDTO;
import org.serratec.backend.projetoFinal.DTO.ClienteExibicaoDTO;
import org.serratec.backend.projetoFinal.exception.ClienteException;
import org.serratec.backend.projetoFinal.model.Cliente;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;


	public ClienteDTO ModelEmDTO(ClienteDTO clienteDTO, Cliente cliente) {

		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNomeCompleto(cliente.getNomeCompleto());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNomeUsuario(cliente.getNomeUsuario());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setTelefonePrincipal(cliente.getTelefonePrincipal());
		clienteDTO.setTelefoneSecundario(cliente.getTelefoneSecundario());
		
		return clienteDTO;

	}

	public Cliente DTOEmModel(ClienteDTO clienteDTO, Cliente cliente) {

		cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNomeUsuario(clienteDTO.getNomeUsuario());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setTelefonePrincipal(clienteDTO.getTelefonePrincipal());
		cliente.setTelefoneSecundario(clienteDTO.getTelefoneSecundario());
		//cliente.setListaEndereco(clienteDTO.getListaEndereco());
		
		return cliente;

	}
	
	public ClienteExibicaoDTO ModelEmDTOExibicao(ClienteExibicaoDTO clienteExibicaoDTO, Cliente cliente) {

		clienteExibicaoDTO.setIdCliente(cliente.getIdCliente());
		clienteExibicaoDTO.setNomeCompleto(cliente.getNomeCompleto());
		clienteExibicaoDTO.setCpf(cliente.getCpf());
		clienteExibicaoDTO.setNomeUsuario(cliente.getNomeUsuario());
		clienteExibicaoDTO.setDataNascimento(cliente.getDataNascimento());
		clienteExibicaoDTO.setEmail(cliente.getEmail());
		clienteExibicaoDTO.setTelefonePrincipal(cliente.getTelefonePrincipal());
		clienteExibicaoDTO.setTelefoneSecundario(cliente.getTelefoneSecundario());
		clienteExibicaoDTO.setListaEndereco(cliente.getListaEndereco());
		
		return clienteExibicaoDTO;

	}

	public String salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		Cliente clienteSalvar = new Cliente();
		clienteSalvar = DTOEmModel(clienteDTO, cliente);
		clienteRepository.save(clienteSalvar);
		return "O cliente foi criado com o id: " + cliente.getIdCliente();
	}

	public ClienteExibicaoDTO buscarPorID(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente buscarCliente = new Cliente();
		ClienteExibicaoDTO clienteExibicaoDTO = new ClienteExibicaoDTO();
		if (cliente.isPresent()) {
			buscarCliente = cliente.get();
			ModelEmDTOExibicao(clienteExibicaoDTO, buscarCliente);
			return clienteExibicaoDTO;
		}
		throw new ClienteException("Cliente com o id informado nao encontrado");
	}

	public List<ClienteExibicaoDTO> buscarTodos() {
		List<Cliente> listaClienteModel = clienteRepository.findAll();
		List<ClienteExibicaoDTO> listaClienteExibicaoDTO = new ArrayList<>();

		for (Cliente cliente : listaClienteModel) {
			ClienteExibicaoDTO clienteExibicaoDTO = new ClienteExibicaoDTO();
			ModelEmDTOExibicao(clienteExibicaoDTO, cliente);
			listaClienteExibicaoDTO.add(clienteExibicaoDTO);

		}
		return listaClienteExibicaoDTO;

	}

	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente atualizarCliente = new Cliente();
		if (cliente.isPresent()) {
			atualizarCliente = cliente.get();
			if (clienteDTO.getCpf() != null) {
				atualizarCliente.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getNomeCompleto() != null) {
				atualizarCliente.setNomeCompleto(clienteDTO.getNomeCompleto());
			}
			if (clienteDTO.getDataNascimento() != null) {
				atualizarCliente.setDataNascimento(clienteDTO.getDataNascimento());
			}
			if (clienteDTO.getNomeUsuario() != null) {
				atualizarCliente.setNomeUsuario(clienteDTO.getNomeUsuario());
			}
			if (clienteDTO.getEmail() != null) {
				atualizarCliente.setEmail(clienteDTO.getEmail());
			}
			if (clienteDTO.getTelefonePrincipal() != null) {
				atualizarCliente.setTelefonePrincipal(clienteDTO.getTelefonePrincipal());
			}
			if (clienteDTO.getTelefoneSecundario() != null) {
				atualizarCliente.setTelefoneSecundario(clienteDTO.getTelefoneSecundario());
			}
			clienteRepository.save(atualizarCliente);
			return "O cliente com o id " + atualizarCliente.getIdCliente() + " foi atualizado";
		}
		throw new ClienteException("O cliente nao foi atualizado");
	}

	public void salvarListaCliente(List<ClienteDTO> listaClienteDTO) {
		List<Cliente> listaCliente = new ArrayList<>();
		for (ClienteDTO clienteDTO : listaClienteDTO) {
			Cliente cliente = new Cliente();
			DTOEmModel(clienteDTO, cliente);
			listaCliente.add(cliente);
		}
		clienteRepository.saveAll(listaCliente);

	}
	
	public void deletar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

}
