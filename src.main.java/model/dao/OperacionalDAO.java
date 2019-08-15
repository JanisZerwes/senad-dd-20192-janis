package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Operacional;

public class OperacionalDAO implements BaseDAO<Operacional> {

	public Operacional salvar(Operacional novoOperacional) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO OPERACIONAL (nome, cpf, sexo, idade, salBruto, id ) " + " VALUES (?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, novoOperacional.getNome());
			stmt.setString(2, novoOperacional.getCpf());
			stmt.setString(3, novoOperacional.getSexo());
			stmt.setInt(4, novoOperacional.getIdade());
			stmt.setDouble(5, novoOperacional.getSalBruto());
			stmt.setInt(6, novoOperacional.getId());

			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir funcionário Operacional .");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoOperacional;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM ENDERECO WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir endereco.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Operacional operacional) {
		Connection conn = Banco.getConnection();
		// (int id, String rua, String cep, String estado, String cidade, String numero,
		// String bairro) {

		String sql = " UPDATE OPERACIONAL " + " SET nome=?, cpf=?, sexo=?, idade=?, salBruto=?, id=?" + " WHERE ID=? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, operacional.getNome());
			stmt.setString(2, operacional.getCpf());
			stmt.setString(3, operacional.getSexo());
			stmt.setInt(4, operacional.getIdade());
			stmt.setDouble(5, operacional.getSalBruto());
			stmt.setInt(5, operacional.getId());

			quantidadeLinhasAfetadas = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar funcionário operacional.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public Operacional consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT  Nome, Cpf, Sexo, Idade, salBruto,id " + " FROM OPERACIONAL " + " WHERE ID=" + id;

		Statement stmt = Banco.getStatement(conn);

		Operacional operacional = null;
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			if (resultadoDaConsulta.next()) {
				operacional = construirOperacionalDoResultSet(resultadoDaConsulta);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar operacional por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}

		return operacional;

	}

	public ArrayList<Operacional> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT Nome, cpf, sexo, idade, salBruto, id " + " FROM OPERACIONAL ";

		Statement stmt = Banco.getStatement(conn);
		ArrayList<Operacional> operacionais = new ArrayList<Operacional>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			while (resultadoDaConsulta.next()) {
				Operacional operacional = construirOperacionalDoResultSet(resultadoDaConsulta);
				operacionais.add(operacional);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereco");
			System.out.println("Erro: " + e.getMessage());
		}

		return operacionais;
	}

	private Operacional construirOperacionalDoResultSet(ResultSet resultadoDaConsulta) {
		Operacional operacional;
		operacional = new Operacional();
		try {

			operacional.setNome(resultadoDaConsulta.getString("Nome"));
			operacional.setCpf(resultadoDaConsulta.getString("Cpf"));
			operacional.setSexo(resultadoDaConsulta.getString("Sexo"));
			operacional.setIdade(resultadoDaConsulta.getInt("Idade"));
			operacional.setSalBruto(resultadoDaConsulta.getDouble("salBruto"));
			operacional.setId(resultadoDaConsulta.getInt("Id"));

		} catch (SQLException e) {
			System.out.println("Erro ao construir operacional a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}

		return operacional;
	}

}
