package com.cadastro.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainContainer extends JPanel{
	private static final long serialVersionUID = 1L;
	int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	
	public  ListaView listaView;
	public CadastroView cadastroView;
	public JLabel head;
	
	ImageIcon fundo = new ImageIcon(getClass().getResource("recursos/Fundo.png"));
	Image i = fundo.getImage();
	public MainContainer() {
		
		setPreferredSize(new Dimension(fundo.getIconWidth(),fundo.getIconHeight()));	
		setLayout(null);	
		
		cadastroView = new CadastroView();
		cadastroView.setLocation(150, 100);
		cadastroView.setPreferredSize(new Dimension(cadastroView.getWidth(),cadastroView.getHeight()));
		cadastroView.setVisible(true);
		add(cadastroView,FlowLayout.RIGHT,0);	
		
		listaView = new ListaView();
		listaView.setLocation(150, 100);
		listaView.setPreferredSize(new Dimension(listaView.getWidth(),listaView.getHeight()));
		listaView.setVisible(false);
		add(listaView);
		
		
		head = new JLabel("Cadastro de clientes");
		head.setFont(new Font("arial",Font.BOLD,25));
		head.setLocation(500, 25);
		head.setSize(250, 50);
		add(head);
		
		JLabel fundo = new JLabel(this.fundo);
		fundo.setBounds(0,0,1300,800);
		add(fundo);
		
	
	}
	

}
