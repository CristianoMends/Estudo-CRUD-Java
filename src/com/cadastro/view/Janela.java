package com.cadastro.view;

import javax.swing.*;

public class Janela extends JFrame{
	
	public Janela() {
		super("CRUD");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(new CadastroView());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
