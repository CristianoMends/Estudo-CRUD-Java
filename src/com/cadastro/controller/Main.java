package com.cadastro.controller;

import javax.swing.JFrame;

import com.cadastro.model.Pessoa;
import com.cadastro.view.CadastroView;

public class Main extends JFrame{
	public Main () {
		super("CRUD");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(new CadastroView());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	}
	
	public static void main(String[] args)  {
		new Main();
		
		
		
	}

}
