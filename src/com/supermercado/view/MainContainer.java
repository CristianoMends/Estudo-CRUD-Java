package com.supermercado.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


public class MainContainer extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	
	public  ListaView listaView;
	public CadastroView cadastroView;
	public JLabel head;
	
	public MainContainer() {
		
		setPreferredSize(new Dimension(largura,altura));
		setBackground(new Color(72,61,139));
		setLayout(null);	
		
		cadastroView = new CadastroView();
		cadastroView.setLocation(150, 100);
		cadastroView.setPreferredSize(new Dimension(cadastroView.getWidth(),cadastroView.getHeight()));
		cadastroView.setVisible(true);
		add(cadastroView,FlowLayout.RIGHT,0);	
		
		listaView = new ListaView();
		listaView.setLocation(25, 100);
		listaView.setPreferredSize(new Dimension(listaView.getWidth(),listaView.getHeight()));
		listaView.setVisible(false);
		add(listaView);
		
		addMouseListener(this);
		
		
		head = new JLabel("Cadastro de clientes");
		head.setFont(new Font("arial",Font.BOLD,25));
		head.setForeground(Color.white);
		head.setLocation(500, 25);
		head.setSize(250, 50);
		add(head);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==3) {
			JPopupMenu jPopupMenu = new JPopupMenu();
			jPopupMenu.add(new JMenuItem("Teste"));			
			jPopupMenu.show(this, e.getX(), e.getY());
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
