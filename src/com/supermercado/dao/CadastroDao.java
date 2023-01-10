package com.supermercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.supermercado.model.entities.Pessoa;

public class CadastroDao {
	public Connection conexao;
	public ArrayList<Pessoa> lista = new ArrayList<>();

	public void cadastrarPessoa(String cpf, String nome, String dataNasc, String telefone, String email, String sexo, String rua,
			String numero, String cidade, String uf) throws SQLException {
		conexao = new Conexao().getConnection();
		String sql = "insert into cliente(cpf,nome,nascimento,email,sexo,rua,numero,cidade,uf,telefone)" + " values('"
				+ cpf + "','" + nome + "','" + dataNasc + "','" + email + "','"+sexo+"','" + rua + "','" + numero + "','" + cidade
				+ "','" + uf + "','" + telefone + "')";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

	}

	public void deletarPessoa(String cpf) throws SQLException {
		conexao = new Conexao().getConnection();
		String sql = "delete from cliente where cpf ='" + cpf + "' ";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();
	}

	public ArrayList<Pessoa> listarPessoas() throws SQLException {
		conexao = new Conexao().getConnection();
		Statement st = conexao.createStatement();
		String sql = "SELECT * FROM cliente";
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			Pessoa pessoa = new Pessoa();

			pessoa.setCpf(rs.getString("cpf"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setNascimento(rs.getString("nascimento"));
			pessoa.setTelefone(rs.getString("telefone"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setRua(rs.getString("rua"));
			pessoa.setCidade(rs.getString("cidade"));
			pessoa.setUf(rs.getString("uf"));
			pessoa.setNumero(rs.getString("numero"));
			pessoa.setSexo(rs.getString("sexo"));
			lista.add(pessoa);

		}

		return lista;
	}

}
