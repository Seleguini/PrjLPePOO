package dao;

import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.executeUpdate();
        }
    }

    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                clientes.add(new Cliente(idCliente, nome, cpf, telefone, email, endereco));
            }
        }
        return clientes;
    }

    // Métodos para atualizar e deletar clientes podem ser adicionados aqui
}