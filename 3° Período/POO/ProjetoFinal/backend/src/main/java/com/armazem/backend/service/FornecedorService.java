package com.armazem.backend.service;

import com.armazem.backend.model.Fornecedor;
import com.armazem.backend.repository.FornecedorDAO;
import java.time.LocalDateTime;
import java.util.List;

public class FornecedorService {

    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public List<Fornecedor> listarTodos() {
        return fornecedorDAO.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        if (fornecedor.getCriadoEm() == null) {
            fornecedor.setCriadoEm(LocalDateTime.now());
        }
        if (fornecedor.getAtivo() == null) {
            fornecedor.setAtivo(true);
        }
        return fornecedorDAO.save(fornecedor);
    }

    public Fornecedor atualizar(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedor = buscarPorId(id);
        fornecedor.setNome(fornecedorAtualizado.getNome());
        fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
        fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
        fornecedor.setEmail(fornecedorAtualizado.getEmail());
        fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
        return fornecedorDAO.update(fornecedor);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        fornecedorDAO.deleteById(id);
    }
}
