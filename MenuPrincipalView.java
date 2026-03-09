package com.example.ProjetoGerenciadorDeTarefa.view;

import com.example.ProjetoGerenciadorDeTarefa.Model.Usuario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipalView extends JFrame {

    private Usuario usuario;
    private JTable tabela;
    private DefaultTableModel modelo;

    public MenuPrincipalView(Usuario usuario) {

        this.usuario = usuario;

        setTitle("Gerenciador de Tarefas");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Bem-vindo, " + usuario.getNomeUsuario());
        lblUsuario.setBounds(20,10,300,30);
        add(lblUsuario);

        // Criar modelo da tabela
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Descrição");
        modelo.addColumn("Concluída");

        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20,50,540,200);
        add(scroll);

        // Botões
        JButton btnNova = new JButton("Nova Tarefa");
        btnNova.setBounds(20,270,120,30);
        add(btnNova);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(150,270,100,30);
        add(btnEditar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(260,270,100,30);
        add(btnExcluir);

        JButton btnConcluir = new JButton("Concluir");
        btnConcluir.setBounds(370,270,100,30);
        add(btnConcluir);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(480,270,80,30);
        add(btnSair);

      
        // BOTÃO NOVA TAREFA
        
        btnNova.addActionListener(e -> {

            String titulo = JOptionPane.showInputDialog(this,"Título da tarefa");

            if(titulo != null && !titulo.isEmpty()){

                String descricao = JOptionPane.showInputDialog(this,"Descrição");

                modelo.addRow(new Object[]{
                        modelo.getRowCount()+1,
                        titulo,
                        descricao,
                        false
                });
            }

        });

        
        // BOTÃO EDITAR
      
        btnEditar.addActionListener(e -> {

            int linha = tabela.getSelectedRow();

            if(linha != -1){

                String tituloAtual = (String) modelo.getValueAt(linha,1);

                String novoTitulo = JOptionPane.showInputDialog(
                        this,
                        "Editar título",
                        tituloAtual
                );

                if(novoTitulo != null && !novoTitulo.isEmpty()){

                    modelo.setValueAt(novoTitulo,linha,1);

                }

            }else{

                JOptionPane.showMessageDialog(this,"Selecione uma tarefa");

            }

        });

       
        // BOTÃO EXCLUIR
        
        btnExcluir.addActionListener(e -> {

            int linha = tabela.getSelectedRow();

            if(linha != -1){

                modelo.removeRow(linha);

            }else{

                JOptionPane.showMessageDialog(this,"Selecione uma tarefa");

            }

        });

        
        // BOTÃO CONCLUIR
        
        btnConcluir.addActionListener(e -> {

            int linha = tabela.getSelectedRow();

            if(linha != -1){

                modelo.setValueAt(true,linha,3);

            }else{

                JOptionPane.showMessageDialog(this,"Selecione uma tarefa");

            }

        });

        
        // BOTÃO SAIR
        
        btnSair.addActionListener(e -> {

            new TelaLogin().setVisible(true);
            dispose();

        });

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNome.setText("Nome");

        txtEmail.setText("Email");

        txtSenha.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        new TelaLogin().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}