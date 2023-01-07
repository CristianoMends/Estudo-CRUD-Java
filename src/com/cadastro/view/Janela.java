package com.cadastro.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Janela extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	MainContainer view = new MainContainer();
	ListaView listaView;
	JMenuBar menuBar = new JMenuBar();
	JMenu MenuFile;
	JMenuItem Itemsair,ItemPainelClientes;
	 
	
	public Janela () {
		super("Cadastro de Cliente");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MenuFile = new JMenu("File");
		Itemsair = new JMenuItem("Sair");
		ItemPainelClientes	= new JMenuItem("Clientes Cadastrados");
		
		setJMenuBar(menuBar);
		menuBar.add(MenuFile);
		
		MenuFile.add(ItemPainelClientes);
		ItemPainelClientes.addActionListener(this);
		
		MenuFile.add(Itemsair);		
		Itemsair.addActionListener(this);
		
		menuBar.add(MenuFile);		
		
		
		
		
		
		getContentPane().add(view);
		pack();
		setLocationRelativeTo(view);
		setVisible(true);

	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==Itemsair) {
			System.exit(0);
		}
		if(e.getSource()==ItemPainelClientes) {
			
			if(view.listaView.isVisible()) {
				view.listaView.setVisible(false);
				view.head.setText("Cadastro de Cliente");
				view.cadastroView.setVisible(true);
			}else {
				view.listaView.setVisible(true);
				view.head.setText("Lista de Clientes");
				view.cadastroView.setVisible(false);

			}
			
		}
		
	}
}