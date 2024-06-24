package gui;

import javax.swing.*;
import java.awt.*;

public class TelaPagamento extends JFrame {
    public TelaPagamento() {
        setTitle("Pagamento");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuração do layout
        setLayout(new GridLayout(10, 2));

        // Seção de seleção do método de pagamento
        add(new JLabel("Método de Pagamento:"));
        String[] metodosPagamento = {"Cartão de Crédito", "Cartão de Débito", "Boleto", "Pix"};
        JComboBox<String> metodoPagamentoBox = new JComboBox<>(metodosPagamento);
        add(metodoPagamentoBox);

        // Campos de entrada para cartão
        JLabel nomeCartaoLabel = new JLabel("Nome no Cartão:");
        JTextField nomeCartaoField = new JTextField(20);
        add(nomeCartaoLabel);
        add(nomeCartaoField);

        JLabel numeroCartaoLabel = new JLabel("Número do Cartão:");
        JTextField numeroCartaoField = new JTextField(20);
        add(numeroCartaoLabel);
        add(numeroCartaoField);

        JLabel validadeLabel = new JLabel("Data de Validade:");
        JTextField validadeField = new JTextField(5);
        add(validadeLabel);
        add(validadeField);

        JLabel cvvLabel = new JLabel("CVV:");
        JTextField cvvField = new JTextField(3);
        add(cvvLabel);
        add(cvvField);

        JLabel cpfLabel = new JLabel("CPF do Titular:");
        JTextField cpfField = new JTextField(11);
        add(cpfLabel);
        add(cpfField);

        // Oculta campos de cartão por padrão
        nomeCartaoLabel.setVisible(false);
        nomeCartaoField.setVisible(false);
        numeroCartaoLabel.setVisible(false);
        numeroCartaoField.setVisible(false);
        validadeLabel.setVisible(false);
        validadeField.setVisible(false);
        cvvLabel.setVisible(false);
        cvvField.setVisible(false);
        cpfLabel.setVisible(false);
        cpfField.setVisible(false);

        // Listener para o combobox
        metodoPagamentoBox.addActionListener(e -> {
            String metodoSelecionado = (String) metodoPagamentoBox.getSelectedItem();
            boolean isCartao = metodoSelecionado.equals("Cartão de Crédito") || metodoSelecionado.equals("Cartão de Débito");

            nomeCartaoLabel.setVisible(isCartao);
            nomeCartaoField.setVisible(isCartao);
            numeroCartaoLabel.setVisible(isCartao);
            numeroCartaoField.setVisible(isCartao);
            validadeLabel.setVisible(isCartao);
            validadeField.setVisible(isCartao);
            cvvLabel.setVisible(isCartao);
            cvvField.setVisible(isCartao);
            cpfLabel.setVisible(isCartao);
            cpfField.setVisible(isCartao);
        });

        JButton pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(e -> {
            String metodoSelecionado = (String) metodoPagamentoBox.getSelectedItem();

            if (metodoSelecionado.equals("Cartão de Crédito") || metodoSelecionado.equals("Cartão de Débito")) {
                // Lógica de pagamento com cartão (exemplo simples)
                if (nomeCartaoField.getText().isEmpty() || numeroCartaoField.getText().isEmpty() ||
                        validadeField.getText().isEmpty() || cvvField.getText().isEmpty() || cpfField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos do cartão.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!");
            } else if (metodoSelecionado.equals("Boleto")) {
                // Lógica de pagamento com boleto (exemplo simples)
                JOptionPane.showMessageDialog(this, "Boleto gerado com sucesso!");
            } else if (metodoSelecionado.equals("Pix")) {
                // Lógica de pagamento com Pix (exemplo simples)
                JOptionPane.showMessageDialog(this, "Pagamento via Pix realizado com sucesso!");
            }
            Carrinho.limparCarrinho();
            this.dispose();  // Fecha a janela de pagamento
        });
        add(new JLabel());  // Espaço vazio
        add(pagarButton);
    }
}