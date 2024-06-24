package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("E-mail:"));
        JTextField emailField = new JTextField(20);
        add(emailField);

        add(new JLabel("Senha:"));
        JPasswordField senhaField = new JPasswordField(20);
        add(senhaField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Lógica de autenticação
            // Se autenticado com sucesso, abrir a TelaPrincipal
            TelaPrincipal telaPrincipal = null;
            try {
                telaPrincipal = new TelaPrincipal();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            telaPrincipal.setVisible(true);
            this.dispose();
        });
        add(loginButton);

        JButton registerButton = new JButton("Registrar-se");
        registerButton.addActionListener(e -> {
            TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
            telaCadastroCliente.setVisible(true);
        });
        add(registerButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
}