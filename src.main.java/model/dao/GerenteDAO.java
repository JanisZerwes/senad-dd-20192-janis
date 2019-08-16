package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Gerente;

public class GerenteDAO implements BaseDAO<Gerente> {

	public Gerente salvar(Gerente novoGerente) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO OPERACIONAL (nome, cpf, sexo, idade, salBruto, Iddiretor ) "
				+ " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, novoGerente.getNome());
			stmt.setString(2, novoGerente.getCpf());
			stmt.setString(3, novoGerente.getSexo());
			stmt.setInt(4, novoGerente.getIdade());
			stmt.setDouble(5, novoGerente.getSalBruto());
			stmt.setInt(6, novoGerente.getIdDiretoria());
			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir funcionário Operacional .");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoGerente;
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

	public boolean alterar(Gerente gerente) {
		Connection conn = Banco.getConnection();
		// (int id, String rua, String cep, String estado, String cidade, String numero,
		// String bairro) {

		String sql = " UPDATE GERENTE " + " SET nome=?, cpf=?, sexo=?, idade=?, salBruto=?, iddiretor=?"
				+ " WHERE ID=? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, gerente.getNome());
			stmt.setString(2, gerente.getCpf());
			stmt.setString(3, gerente.getSexo());
			stmt.setInt(4, gerente.getIdade());
			stmt.setDouble(5, gerente.getSalBruto());
			stmt.setInt(6, gerente.getIdDiretoria());

			quantidadeLinhasAfetadas = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar gerente.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public Gerente consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT  Nome, Cpf, Sexo, Idade, salBruto,iddiretor " + " FROM GERENTE " + " WHERE ID=" + id;

		Statement stmt = Banco.getStatement(conn);

		Gerente gerente = null;
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			if (resultadoDaConsulta.next()) {
				gerente = construirGerenteDoResultSet(resultadoDaConsulta);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar gerente por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}

		return gerente;
	}

	private Gerente construirGerenteDoResultSet(ResultSet resultadoDaConsulta) {
		Gerente gerente;
		gerente = new Gerente();
		try {

			gerente.setNome(resultadoDaConsulta.getString("Nome"));
			gerente.setCpf(resultadoDaConsulta.getString("Cpf"));
			gerente.setSexo(resultadoDaConsulta.getString("Sexo"));
			gerente.setIdade(resultadoDaConsulta.getInt("Idade"));
			gerente.setSalBruto(resultadoDaConsulta.getDouble("salBruto"));
			gerente.setIdDiretoria(resultadoDaConsulta.getInt("IdDiretor"));

		} catch (SQLException e) {
			System.out.println("Erro ao construir gerente a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}

		return gerente;
	}

	public ArrayList<Gerente> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT Nome, cpf, sexo, idade, salBruto, iddiretor " + " FROM GERENTE ";

		Statement stmt = Banco.getStatement(conn);
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			while (resultadoDaConsulta.next()) {
				Gerente gerente = construirGerenteDoResultSet(resultadoDaConsulta);
				gerentes.add(gerente);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereco");
			System.out.println("Erro: " + e.getMessage());
		}

		return gerentes;
	}

}
