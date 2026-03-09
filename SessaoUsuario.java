package com.example.ProjetoGerenciadorDeTarefa.sessao;

import com.example.ProjetoGerenciadorDeTarefa.Model.Usuario;

public class SessaoUsuario {

    private static Usuario usuarioLogado;

    // Inicia a sessão
    public static void iniciarSessao(Usuario usuario) {
        usuarioLogado = usuario;
    }

    // Retorna o usuário logado
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    // Encerra a sessão
    public static void encerrarSessao() {
        usuarioLogado = null;
    }

    // Verifica se existe usuário logado
    public static boolean estaLogado() {
        return usuarioLogado != null;
    }
}
