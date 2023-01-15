package com.supermercado.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Conexao {
	private String database = "supermercado";
	private String username = "root";
	private String password = "cristiano@1234";
	private String ip = "localhost";
	LocalDateTime data =LocalDateTime.now();
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private int port = 3306;
	public Connection connection;
	
	
	public Connection getConnection(){
		if(connection == null) {
		String url = String.format("jdbc:mysql:// %s : %d / %s",ip,port,database);
		try {
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("Conectado com sucesso!");
			System.out.printf("Banco de dados: %s\nIP: %s\nPorta: %d\n",database,ip,port);
			System.out.println(data.getDayOfWeek()+" "+data.format(df)+"\n");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados "+e.getMessage());
			System.err.println("Erro ao conectar com banco");
		}finally {}
		
		}
		return connection;
		
	}
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(Connection c) {
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
