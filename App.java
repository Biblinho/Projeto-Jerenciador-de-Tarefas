package com.example.ProjetoGerenciadorDeTarefa;

import com.example.ProjetoGerenciadorDeTarefa.view.TelaCadastro;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });

    }
}