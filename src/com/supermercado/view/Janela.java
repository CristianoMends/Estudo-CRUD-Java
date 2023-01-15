package com.supermercado.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
public class Janela extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	MainContainer view = new MainContainer();
	ListaView listaView;
	JMenuBar menuBar = new JMenuBar();
	JMenu menuFile;
	JMenuItem itemsair,itemPainelClientes,itemPainelCadastro;
	
	public Janela () {
		super("Supermercado v1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuFile = new JMenu("File");
		itemsair = new JMenuItem("Sair");
		itemPainelClientes	= new JMenuItem("Acessar cliente");
		itemPainelCadastro = new JMenuItem("Novo cadastro");
		
		setJMenuBar(menuBar);
		menuBar.add(menuFile);
		
		menuFile.add(itemPainelClientes);
		menuFile.add(itemPainelCadastro);
		itemPainelClientes.addActionListener(this);
		itemPainelCadastro.addActionListener(this);
		
		menuFile.add(itemsair);		
		itemsair.addActionListener(this);
		
		menuBar.add(menuFile);
		
		JScrollPane scroll = new JScrollPane(view);
		scroll.setPreferredSize(new Dimension(500,500));
		getContentPane().add(scroll);
		pack();
		setLocationRelativeTo(view);
		setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource()==itemsair) {
			System.exit(0);
		}
		if(e.getSource()==itemPainelClientes || view.listaView.isVisible()) {
				view.head.setText("Lista de Clientes");
				view.cadastroView.setVisible(false);
				view.listaView.setVisible(true);
			
		}if(e.getSource()==itemPainelCadastro || view.cadastroView.isVisible()) {
			view.head.setText("Cadastro de Cliente");
			view.listaView.setVisible(false);
			view.cadastroView.setVisible(true);
			
		}
	}
}