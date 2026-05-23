package com.oficina.dao;

import com.oficina.model.OrdemServico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {
    public void salvar(OrdemServico os) {
        String sql = "INSERT INTO ordem_servico (descricao, valor, cliente_id) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, os.getDescricao());
            stmt.setDouble(2, os.getValor());
            stmt.setInt(3, os.getClienteId());
            stmt.executeUpdate();
            System.out.println("OS salva com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar OS: " + e.getMessage());
        }
    }

    public List<OrdemServico> listar() {
        List<OrdemServico> ordens = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico";
        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OrdemServico os = new OrdemServico();
                os.setId(rs.getInt("id"));
                os.setDescricao(rs.getString("descricao"));
                os.setValor(rs.getDouble("valor"));
                os.setClienteId(rs.getInt("cliente_id"));
                ordens.add(os);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar OS: " + e.getMessage());
        }
        return ordens;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM ordem_servico WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("OS deletada!");
        } catch (SQLException e) {
             System.err.println("Erro ao deletar OS: " + e.getMessage());
        }
    }
}