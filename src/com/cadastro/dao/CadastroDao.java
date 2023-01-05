package com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cadastro.model.Pessoa;


public class CadastroDao {
	public Connection conexao;
	public ArrayList<Pessoa>lista = new ArrayList<>();
	
	public void cadastrarPessoa(String nome,String dataNasc,String telefone) throws SQLException {
		conexao = new Conexao().getConnection();
		String sql = "insert into pessoa(nome,dataNasc,telefone) values ('"+nome+"','"+dataNasc+"','"+telefone+"')";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();
		
	}
	public void deletarPessoa(int cod) throws SQLException {
		conexao = new Conexao().getConnection();
		String sql = "delete from pessoa where cod ='"+cod+"' ";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();
	}
	public ArrayList<Pessoa> listarPessoas() throws SQLException {
		conexao = new Conexao().getConnection();
		Statement st = conexao.createStatement();
	      String sql = "SELECT * FROM pessoa";
	      ResultSet rs = st.executeQuery(sql);	      
	      
	      while(rs.next()){
	  		 Pessoa pessoa = new Pessoa();	  		 

	          pessoa.setCod(rs.getInt("cod"));
	          pessoa.setNome(rs.getString("nome"));
	          pessoa.setDataNasc(rs.getString("dataNasc"));
	          pessoa.setTelefone(rs.getString("telefone"));
	          lista.add(pessoa);
	         
	        }
	      
          return lista;
	}
	
	
}
