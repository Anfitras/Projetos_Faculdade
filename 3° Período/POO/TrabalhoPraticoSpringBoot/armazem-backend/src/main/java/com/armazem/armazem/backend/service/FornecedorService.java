package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.Fornecedor;
import com.armazem.armazem.backend.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Fornecedor atualizar(Long id, Fornecedor fornecedorAtualizado) {
        return repository.findById(id).map(fornecedor -> {
            fornecedor.setNome(fornecedorAtualizado.getNome());
            fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
            fornecedor.setEmail(fornecedorAtualizado.getEmail());
            fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
            return repository.save(fornecedor);
        }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
