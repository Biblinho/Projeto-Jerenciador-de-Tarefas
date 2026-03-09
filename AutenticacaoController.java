package com.example.ProjetoGerenciadorDeTarefa.controller;

import com.example.ProjetoGerenciadorDeTarefa.Model.Usuario;
import com.example.ProjetoGerenciadorDeTarefa.dao.UsuarioDAO;
import org.mindrot.jbcrypt.BCrypt;

public class AutenticacaoController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean cadastrarUsuario(String nome, String senha) {

        if (nome == null || nome.trim().isEmpty() ||
            senha == null || senha.trim().isEmpty()) {

            throw new IllegalArgumentException("Nome e senha são obrigatórios.");
        }

        // verifica se usuário já existe
        if (usuarioDAO.buscarPorNome(nome) != null) {
            throw new IllegalArgumentException("Usuário já existe.");
        }

        // gera hash da senha
        String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nome);
        usuario.setSenhaHash(senhaHash);

        usuarioDAO.salvarUsuario(usuario);

        return true;
    }

    public Usuario autenticar(String nome, String senha) {

        if (nome == null || senha == null) {
            throw new IllegalArgumentException("Nome e senha são obrigatórios.");
        }

        Usuario usuario = usuarioDAO.buscarPorNome(nome);

        if (usuario == null) {
            return null;
        }

        // verifica senha
        if (BCrypt.checkpw(senha, usuario.getSenhaHash())) {
            return usuario;
        }

        return null;
    }
}