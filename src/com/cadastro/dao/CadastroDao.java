package com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CadastroDao {
	public Connection conexao;
	String lista = "";
   

	
	
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
	public String listarPessoas() throws SQLException {
		conexao = new Conexao().getConnection();
		Statement st = conexao.createStatement();
	      String sql = "SELECT * FROM pessoa";
	      ResultSet rs = st.executeQuery(sql);	      
	      
	      while(rs.next()){	
	    	  StringBuilder sb = new StringBuilder();
	          int cod = rs.getInt("cod");
	          String nome = rs.getString("nome");
	          String dataNasc = rs.getString("dataNasc");
	          String telefone = rs.getString("telefone");
	          sb.append("Codigo: "+cod);
	          sb.append("| Nome: "+nome);
	          sb.append("| Nascimento: "+dataNasc);
	          sb.append("| Telefone: "+telefone);
	          sb.append("\n");
	          lista +=String.format("COD: %3s |NOME: %20s |Nascimento: %10s |Telefone: %12s\n",cod,nome,dataNasc,telefone);
	        }
          return lista;
	}
	
	
}
