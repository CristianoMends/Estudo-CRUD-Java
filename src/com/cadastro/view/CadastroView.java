package com.cadastro.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.cadastro.controller.CadastroController;

public class CadastroView extends JPanel implements KeyListener,ActionListener{
	public JTextField txtNome,txtTel,txtDataNasc,cidade,uf;
	 JButton btnCadastrar;
	JRadioButton m,f;
	public CadastroView() {
		setSize(1000,400);
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JPanel cadastroPanel = new JPanel();
		cadastroPanel.setPreferredSize(new Dimension(500,400));
		cadastroPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		add(cadastroPanel);
		
		JPanel panelEnd = new JPanel();
		panelEnd.setPreferredSize(new Dimension(500,400));
		panelEnd.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
		add(panelEnd);
		
   try {
			
		
		
		JLabel nome = new JLabel("Nome");
		nome.setPreferredSize(new Dimension(500,25));
		nome.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(nome,FlowLayout.LEFT,0);
		
		txtNome = new JTextField(20);
		txtNome.setPreferredSize(new Dimension(500,25));
		txtNome.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtNome,FlowLayout.LEFT,1);
		
		JLabel nasc = new JLabel("Nascimento");
		nasc.setPreferredSize(new Dimension(500,25));
		nasc.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(nasc,FlowLayout.LEFT,2);
		
		txtDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataNasc.setColumns(20);
		txtDataNasc.setPreferredSize(new Dimension(500,25));
		txtDataNasc.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtDataNasc,FlowLayout.LEFT,3);
		txtDataNasc.addKeyListener(this);
		
		JLabel tel = new JLabel("Telefone");
		tel.setFont(new Font("",Font.BOLD,14));
		tel.setPreferredSize(new Dimension(500,25));
		cadastroPanel.add(tel,FlowLayout.LEFT,4);
		
		txtTel = new JFormattedTextField(new MaskFormatter("(##)# ####-####"));
		txtTel.setColumns(10);
		txtTel.setPreferredSize(new Dimension(500,25));
		txtTel.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtTel,FlowLayout.LEFT,5);
		txtTel.addKeyListener(this);
		
		JLabel sexo = new JLabel("Sexo");
		sexo.setFont(new Font("",Font.BOLD,14));
		sexo.setPreferredSize(new Dimension(500,25));
		cadastroPanel.add(sexo,FlowLayout.LEFT,6);
		
		m = new JRadioButton("M");
		f = new JRadioButton("F");
		m.setPreferredSize(new Dimension(50, 15));
		f.setPreferredSize(new Dimension(350,25));
		cadastroPanel.add(m,FlowLayout.LEFT,7);
		cadastroPanel.add(f,FlowLayout.LEFT,8);
		
		
		JLabel cidade = new JLabel("Cidade");
		cidade.setPreferredSize(new Dimension(500,25));
		cidade.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(cidade,FlowLayout.LEFT,0);
		
		this.cidade = new JTextField(20);
		this.cidade.setPreferredSize(new Dimension(500,25));
		this.cidade.setFont(new Font("",Font.BOLD,15));
		panelEnd.add(this.cidade,FlowLayout.LEFT,1);
		
		JLabel uf = new JLabel("UF");
		uf.setPreferredSize(new Dimension(500, 25));
		uf.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(uf,FlowLayout.LEFT,2);
		
		this.uf = new JTextField(20);
		this.uf.setPreferredSize(new Dimension(500,25));
		this.uf.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(this.uf,FlowLayout.LEFT,3);
				
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setLocation(500,350);
		cadastroPanel.add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
	} 
  catch (ParseException e) {
	  JOptionPane.showMessageDialog(null, "Erro: "+e);
	  e.printStackTrace();
		}
   
		}
	@Override
	public void actionPerformed(ActionEvent e) {			
		
		if(e.getSource()==btnCadastrar) {
			CadastroController controller = new CadastroController();
			try {
				controller.cadastrarPessoa(this);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastar!");
				e1.printStackTrace();
			}

		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//Condicoes para Data de nascimento
		String key = String.valueOf(e.getKeyChar());		
		if(e.getComponent()==txtDataNasc && e.getKeyCode()!=8) {
			if( !key.matches("[0-9]*")) {JOptionPane.showMessageDialog(txtDataNasc, "Digite apenas numeros! ");}
											}	
		
		//Condicoes para telefone
		if(e.getComponent()==txtTel && e.getKeyCode()!=8) {
			if(e.getComponent()==txtTel) {
				if( !key.matches("[0-9]*")) {JOptionPane.showMessageDialog(txtDataNasc, "Digite apenas numeros!!");}
			}}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
