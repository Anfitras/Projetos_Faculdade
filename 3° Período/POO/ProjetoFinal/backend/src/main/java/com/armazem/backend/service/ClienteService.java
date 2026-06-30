package com.armazem.backend.service;

import com.armazem.backend.model.Cliente;
import com.armazem.backend.repository.ClienteDAO;
import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> listarTodos() {
        return clienteDAO.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null && clienteDAO.findByCpf(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF ja cadastrado");
        }
        return clienteDAO.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEmail(clienteAtualizado.getEmail());
        return clienteDAO.update(cliente);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        clienteDAO.deleteById(id);
    }
}
