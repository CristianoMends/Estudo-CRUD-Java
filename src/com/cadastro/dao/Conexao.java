package com.cadastro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {	
	public Connection connection;
	
	public Connection getConnection() throws SQLException {
		String username = "root",password = "cristiano@1234";
		String url = "jdbc:mysql://localhost:3306/crud";
		connection = DriverManager.getConnection(url,username,password);
		System.out.println("Conectado ao banco");
		return connection;
		
	}
}
