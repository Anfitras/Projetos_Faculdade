package com.armazem.backend.repository;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.model.Fornecedor;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FornecedorDAO {

    public List<Fornecedor> findAll() {
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Optional<Fornecedor> findById(Long id) {
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public Fornecedor save(Fornecedor f) {
        String sql = "INSERT INTO fornecedor (nome, cnpj, telefone, email, endereco, ativo, criado_em) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getEndereco());
            stmt.setBoolean(6, f.getAtivo() != null ? f.getAtivo() : true);
            stmt.setTimestamp(7, Timestamp.valueOf(f.getCriadoEm() != null ? f.getCriadoEm() : LocalDateTime.now()));
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    f.setId(keys.getLong(1));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return f;
    }

    public Fornecedor update(Fornecedor f) {
        String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getEndereco());
            stmt.setLong(6, f.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return f;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM fornecedor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fornecedor map(ResultSet rs) throws SQLException {
        Fornecedor f = new Fornecedor();
        f.setId(rs.getLong("id"));
        f.setNome(rs.getString("nome"));
        f.setCnpj(rs.getString("cnpj"));
        f.setTelefone(rs.getString("telefone"));
        f.setEmail(rs.getString("email"));
        f.setEndereco(rs.getString("endereco"));
        f.setAtivo(rs.getBoolean("ativo"));
        f.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
        return f;
    }
}
