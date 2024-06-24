package gui;

import model.Produto;
import dao.ProdutoDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() throws SQLException {
        setTitle("Vitrine de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel produtosPanel = new JPanel();
        produtosPanel.setLayout(new GridLayout(0, 1)); // Uma coluna, várias linhas

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarProdutos();
        for (Produto produto : produtos) {
            JPanel produtoPanel = new JPanel();
            produtoPanel.setLayout(new GridLayout(1, 2));

            JLabel produtoLabel = new JLabel("<html><b>" + produto.getNome() + "</b><br/>" +
                    "Categoria: " + produto.getCategoria() + "<br/>" +
                    "Preço: R$" + produto.getPreco() + "<br/>" +
                    "Descrição: " + produto.getDescricao() + "</html>");
            produtoPanel.add(produtoLabel);

            produtosPanel.add(produtoPanel);
        }

        add(new JScrollPane(produtosPanel), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                run();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void run() throws SQLException {
        TelaPrincipal telaPrincipal = new T     elaPrincipal();
        telaPrincipal.setVisible(true);
    }
}