package com.example.ProjetoGerenciadorDeTarefa.controller;

import com.example.ProjetoGerenciadorDeTarefa.Model.Tarefa;
import com.example.ProjetoGerenciadorDeTarefa.dao.TarefaDAO;

import java.sql.SQLException;
import java.util.List;

public class TarefaController {

    private final TarefaDAO tarefaDAO = new TarefaDAO();

    public void criar(String titulo, String descricao, int usuarioId) throws SQLException {

        validarTitulo(titulo);

        Tarefa tarefa = new Tarefa(titulo, descricao, usuarioId);

        tarefaDAO.salvar(tarefa);
    }

    public List<Tarefa> listar(int usuarioId) throws SQLException {

        return tarefaDAO.buscarPorUsuario(usuarioId);
    }

    public void atualizar(Tarefa tarefa) throws SQLException {

        tarefaDAO.atualizar(tarefa);
    }

    public void excluir(int id, int usuarioId) throws SQLException {

        tarefaDAO.excluir(id, usuarioId);
    }

    private void validarTitulo(String titulo) {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título obrigatório.");
        }
    }
}