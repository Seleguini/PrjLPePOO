package dao;

import model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Funcionario (idFuncionario, nome, cpf, telefone, email, cargo, dataContratacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getCargo());
            stmt.setDate(7, new Date(funcionario.getDataContratacao().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idFuncionario = rs.getInt("idFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                Date dataContratacao = rs.getDate("dataContratacao");
                funcionarios.add(new Funcionario(idFuncionario, nome, cpf, telefone, email, cargo, dataContratacao));
            }
        }
        return funcionarios;
    }
}