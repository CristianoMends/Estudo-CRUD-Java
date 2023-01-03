package com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDao {
	public Connection conexao;
	
	
	public void cadastrarPessoa(String nome,String dataNasc,String telefone) throws SQLException {
		conexao = new Conexao().getConnection();
		String sql = "insert into pessoa(nome,dataNasc,telefone) values ('"+nome+"','"+dataNasc+"','"+telefone+"')";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();
		
	}

}
