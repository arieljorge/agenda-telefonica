package com.github.arieljorge.dao;

import com.github.arieljorge.model.Contato;
import com.github.arieljorge.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void adicionar(Contato contato) throws SQLException {
        String sql = "INSERT INTO contato(nome, telefone, email) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());

            stmt.executeUpdate();
        }
    }

    public boolean remover(String nome) throws SQLException {
        String sql = "DELETE FROM contato WHERE nome = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            return stmt.executeUpdate() > 0;
        }
    }

    public Contato buscar(String nome) throws SQLException {
        String sql = "SELECT * FROM contato WHERE nome = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Contato(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
            }
        }

        return null;
    }

    public List<Contato> listar() throws SQLException {
        String sql = "SELECT * FROM contato ORDER BY nome";

        List<Contato> contatos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                contatos.add(
                        new Contato(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("telefone"),
                                rs.getString("email")
                        )
                );
            }
        }

        return contatos;
    }

    public boolean atualizar(Contato contato) throws SQLException {
        String sql = "UPDATE contato SET telefone = ?, email = ? WHERE nome = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getTelefone());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getNome());

            return stmt.executeUpdate() > 0;
        }
    }
}
