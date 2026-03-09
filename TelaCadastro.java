package com.example.ProjetoGerenciadorDeTarefa.view;

import com.example.ProjetoGerenciadorDeTarefa.controller.AutenticacaoController;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {
 private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;

    private final AutenticacaoController controller = new AutenticacaoController();

    public TelaCadastro() {

        setTitle("Cadastro de Usuário");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblUsuario = new javax.swing.JLabel("Usuário:");
        lblUsuario.setBounds(30,30,80,25);
        add(lblUsuario);

        txtUsuario = new javax.swing.JTextField();
        txtUsuario.setBounds(120,30,120,25);
        add(txtUsuario);

        lblSenha = new javax.swing.JLabel("Senha:");
        lblSenha.setBounds(30,70,80,25);
        add(lblSenha);

        txtSenha = new javax.swing.JPasswordField();
        txtSenha.setBounds(120,70,120,25);
        add(txtSenha);

        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnCadastrar.setBounds(40,120,100,30);
        add(btnCadastrar);

        btnVoltar = new javax.swing.JButton("Voltar");
        btnVoltar.setBounds(150,120,90,30);
        add(btnVoltar);

        btnCadastrar.addActionListener(e -> cadastrarUsuario());

        btnVoltar.addActionListener(e -> {
            new TelaLogin().setVisible(true);
            dispose();
        });
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         
          java.awt.EventQueue.invokeLater(() -> new TelaCadastro().setVisible(true));
}

private void cadastrarUsuario() {

    String usuario = txtUsuario.getText().trim();
    String senha = new String(txtSenha.getPassword()).trim();

    if (usuario.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
        return;
    }

    try {

        boolean sucesso = controller.cadastrarUsuario(usuario, senha);

        if (sucesso) {

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

            // abrir tela de login
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);

            // fechar tela atual
            dispose();

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e.getMessage());

    }

}
}

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

