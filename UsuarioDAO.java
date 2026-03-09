package com.example.ProjetoGerenciadorDeTarefa.dao;

import com.example.ProjetoGerenciadorDeTarefa.Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void salvarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome_usuario, senha_hash) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenhaHash());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário no banco de dados.", e);
        }
    }

    public Usuario buscarPorNome(String nomeUsuario) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário no banco de dados.", e);
        }

        return null;
    }

    // Método privado para mapear ResultSet -> Usuario
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(rs.getInt("id"));
        usuario.setNomeUsuario(rs.getString("nome_usuario"));
        usuario.setSenhaHash(rs.getString("senha_hash"));

        return usuario;
    }
}