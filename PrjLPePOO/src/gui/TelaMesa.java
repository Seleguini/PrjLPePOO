package gui;

import dao.ProdutoDAO;
import model.Produto;
import model.Cardapio;
import dao.CardapioDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TelaMesa extends JFrame {
    public TelaMesa() throws SQLException {
        setTitle("Mesa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel mesaPanel = new JPanel();
        mesaPanel.setLayout(new GridLayout(0, 1));

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarProdutos(); // Devem ser produtos na mesa
        for (Produto produto : produtos) {
            JPanel produtoPanel = new JPanel();
            produtoPanel.setLayout(new GridLayout(1, 2));

            JLabel produtoLabel = new JLabel("<html><b>" + produto.getNome() + "</b><br/>" +
                    "Categoria: " + produto.getCategoria() + "<br/>" +
                    "Preço: R$" + produto.getPreco() + "<br/>" +
                    "Descrição: " + produto.getDescricao() + "</html>");
            produtoPanel.add(produtoLabel);
        }

        add(new JScrollPane(mesaPanel), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaMesa telaMesa = null;
            try {
                telaMesa = new TelaMesa();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            telaMesa.setVisible(true);
        });
    }
}