package com.oficina.dao;

import com.oficina.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cep, logradouro, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCep());
            stmt.setString(3, cliente.getLogradouro());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getLocalidade());
            stmt.setString(6, cliente.getUf());
            stmt.executeUpdate();
            System.out.println("Cliente salvo com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCep(rs.getString("cep"));
                c.setLogradouro(rs.getString("logradouro"));
                c.setBairro(rs.getString("bairro"));
                c.setLocalidade(rs.getString("cidade"));
                c.setUf(rs.getString("estado"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException e) {
             System.err.println("Erro ao deletar: " + e.getMessage());
        }
    }
}