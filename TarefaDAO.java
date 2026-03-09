package com.example.ProjetoGerenciadorDeTarefa.dao;

import com.example.ProjetoGerenciadorDeTarefa.Model.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    private static final String INSERT_TAREFA =
            "INSERT INTO tarefas (titulo, descricao, usuario_id) VALUES (?, ?, ?)";

    private static final String SELECT_POR_USUARIO =
            "SELECT * FROM tarefas WHERE usuario_id = ?";

    private static final String UPDATE_TAREFA =
            "UPDATE tarefas SET titulo=?, descricao=?, concluida=? WHERE id=? AND usuario_id=?";

    private static final String DELETE_TAREFA =
            "DELETE FROM tarefas WHERE id=? AND usuario_id=?";


    public void salvar(Tarefa tarefa) throws SQLException {

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_TAREFA)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setInt(3, tarefa.getUsuarioId());

            stmt.executeUpdate();
        }
    }


    public List<Tarefa> buscarPorUsuario(int usuarioId) throws SQLException {

        List<Tarefa> tarefas = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_POR_USUARIO)) {

            stmt.setInt(1, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    tarefas.add(mapearTarefa(rs));
                }
            }
        }

        return tarefas;
    }


    public void atualizar(Tarefa tarefa) throws SQLException {

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_TAREFA)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.isConcluida());
            stmt.setInt(4, tarefa.getId());
            stmt.setInt(5, tarefa.getUsuarioId());

            stmt.executeUpdate();
        }
    }


    public void excluir(int id, int usuarioId) throws SQLException {

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_TAREFA)) {

            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);

            stmt.executeUpdate();
        }
    }


    private Tarefa mapearTarefa(ResultSet rs) throws SQLException {

        Tarefa tarefa = new Tarefa();

        tarefa.setId(rs.getInt("id"));
        tarefa.setTitulo(rs.getString("titulo"));
        tarefa.setDescricao(rs.getString("descricao"));
        tarefa.setConcluida(rs.getBoolean("concluida"));
        tarefa.setUsuarioId(rs.getInt("usuario_id"));

        return tarefa;
    }
}