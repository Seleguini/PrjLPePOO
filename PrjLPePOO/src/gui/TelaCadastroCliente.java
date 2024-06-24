package gui;

import model.Cliente;
import dao.ClienteDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TelaCadastroCliente extends JFrame {
    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(8, 2));

        add(new JLabel("ID Cliente:"));
        JTextField idClienteField = new JTextField(20);
        add(idClienteField);

        add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField(20);
        add(nomeField);

        add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField(20);
        add(cpfField);

        add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField(20);
        add(telefoneField);

        add(new JLabel("E-mail:"));
        JTextField emailField = new JTextField(20);
        add(emailField);

        add(new JLabel("Endereço:"));
        JTextField enderecoField = new JTextField(20);
        add(enderecoField);

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(e -> {
            try {
                int idCliente = Integer.parseInt(idClienteField.getText());
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String telefone = telefoneField.getText();
                String email = emailField.getText();
                String endereco = enderecoField.getText();

                Cliente cliente = new Cliente(idCliente, nome, cpf, telefone, email, endereco);
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.adicionarCliente(cliente);
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
            telaCadastroCliente.setVisible(true);
        });
    }
}