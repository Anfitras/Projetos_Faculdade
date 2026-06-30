package com.armazem.backend.service;

import com.armazem.backend.model.Fornecedor;
import com.armazem.backend.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor nao encontrado"));
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        if (fornecedor.getCriadoEm() == null) {
            fornecedor.setCriadoEm(LocalDateTime.now());
        }
        if (fornecedor.getAtivo() == null) {
            fornecedor.setAtivo(true);
        }
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor atualizar(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedor = buscarPorId(id);
        fornecedor.setNome(fornecedorAtualizado.getNome());
        fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
        fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
        fornecedor.setEmail(fornecedorAtualizado.getEmail());
        fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
        return fornecedorRepository.save(fornecedor);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        fornecedorRepository.deleteById(id);
    }
}
