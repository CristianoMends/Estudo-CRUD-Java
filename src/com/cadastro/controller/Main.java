package com.cadastro.controller;

import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.JFrame;

import com.cadastro.view.CadastroView;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public Main () {
		super("CRUD");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		getContentPane().add(new CadastroView());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	
	}
	
	public static void main(String[] args) throws ParseException  {
		new Main();
		
		
	}
}