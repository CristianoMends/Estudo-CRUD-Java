package com.supermercado.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String database = "supermercado";
	private String username = "root";
	private String password = "cristiano@1234";
	private String ip = "localhost";
	private int port = 3306;
	public Connection connection;
	
	public Connection getConnection() throws SQLException {
		if(connection == null) {
		String url = String.format("jdbc:mysql:// %s : %d / %s",ip,port,database);
		//String url = "jdbc:mysql://"+ip+":"+porta+"/"+database;
		connection = DriverManager.getConnection(url,username,password);
		System.out.println("Conectado com sucesso!");
		System.out.printf("Banco de dados: %s\nIP: %s\nPorta: %d",database,ip,port);
		}
		return connection;
		
	}
}
