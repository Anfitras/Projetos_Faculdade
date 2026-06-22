package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.Cliente;
import com.armazem.armazem.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null && clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF ja cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEmail(clienteAtualizado.getEmail());
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}
