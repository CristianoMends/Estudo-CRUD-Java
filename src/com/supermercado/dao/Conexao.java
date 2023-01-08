package com.supermercado.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String database = "supermercado";
	private String username = "root";
	private String password = "cristiano@1234";
	public Connection connection;
	
	public Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/"+database;
		connection = DriverManager.getConnection(url,username,password);
		System.out.println("Conectado ao banco");
		return connection;
		
	}
}
