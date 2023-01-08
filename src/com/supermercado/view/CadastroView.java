package com.supermercado.view;

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

import com.supermercado.controller.CadastroController;
import com.supermercado.model.Pessoa;

public class CadastroView extends JPanel implements KeyListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtNome,txtTel,txtDataNasc,txtEmail,txtCpf,txtCidade,txtUf,txtRua,txtNumero;
	public String sexo;
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
		
		JLabel cpf = new JLabel("CPF");
		cpf.setPreferredSize(new Dimension(500,25));
		cpf.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(cpf,FlowLayout.LEFT,2);
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setColumns(14);
		txtCpf.setPreferredSize(new Dimension(500,25));
		txtCpf.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtCpf,FlowLayout.LEFT,3);
		txtCpf.addKeyListener(this);
		
		JLabel nasc = new JLabel("Nascimento");
		nasc.setPreferredSize(new Dimension(500,25));
		nasc.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(nasc,FlowLayout.LEFT,4);
		
		txtDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataNasc.setColumns(10);
		txtDataNasc.setPreferredSize(new Dimension(500,25));
		txtDataNasc.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtDataNasc,FlowLayout.LEFT,5);
		txtDataNasc.addKeyListener(this);
		
		JLabel tel = new JLabel("Telefone");
		tel.setFont(new Font("",Font.BOLD,14));
		tel.setPreferredSize(new Dimension(500,25));
		cadastroPanel.add(tel,FlowLayout.LEFT,6);
		
		txtTel = new JFormattedTextField(new MaskFormatter("(##)# ####-####"));
		txtTel.setColumns(10);
		txtTel.setPreferredSize(new Dimension(500,25));
		txtTel.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtTel,FlowLayout.LEFT,7);
		txtTel.addKeyListener(this);
		
		JLabel email = new JLabel("E-Mail");
		email.setFont(new Font("",Font.BOLD,14));
		email.setPreferredSize(new Dimension(500,25));
		cadastroPanel.add(email,FlowLayout.LEFT,6);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setPreferredSize(new Dimension(500,25));
		txtEmail.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtEmail,FlowLayout.LEFT,7);
		txtTel.addKeyListener(this);
		
		JLabel sexo = new JLabel("Sexo");
		sexo.setFont(new Font("",Font.BOLD,14));
		sexo.setPreferredSize(new Dimension(500,25));
		cadastroPanel.add(sexo,FlowLayout.LEFT,8);
		
		m = new JRadioButton("M");
		f = new JRadioButton("F");
		m.setPreferredSize(new Dimension(50, 15));
		f.setPreferredSize(new Dimension(350,25));
		cadastroPanel.add(m,FlowLayout.LEFT,9);
		cadastroPanel.add(f,FlowLayout.LEFT,10);
		
		JLabel rua = new JLabel("Rua");
		rua.setPreferredSize(new Dimension(500, 25));
		rua.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(rua,FlowLayout.LEFT,0);
		
		txtRua = new JTextField(20);
		txtRua.setPreferredSize(new Dimension(500,25));
		txtRua.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(txtRua,FlowLayout.LEFT,1);
		
		JLabel n = new JLabel("Numero");
		n.setPreferredSize(new Dimension(500, 25));
		n.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(n,FlowLayout.LEFT,2);
		
		txtNumero = new JTextField(4);
		txtNumero.setPreferredSize(new Dimension(500,25));
		txtNumero.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(txtNumero,FlowLayout.LEFT,3);
		
		JLabel cidade = new JLabel("Cidade");
		cidade.setPreferredSize(new Dimension(500,25));
		cidade.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(cidade,FlowLayout.LEFT,4);
		
		this.txtCidade = new JTextField(20);
		this.txtCidade.setPreferredSize(new Dimension(500,25));
		this.txtCidade.setFont(new Font("",Font.BOLD,15));
		panelEnd.add(this.txtCidade,FlowLayout.LEFT,5);
		
		JLabel uf = new JLabel("UF");
		uf.setPreferredSize(new Dimension(500, 25));
		uf.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(uf,FlowLayout.LEFT,6);
		
		this.txtUf = new JTextField(20);
		this.txtUf.setPreferredSize(new Dimension(500,25));
		this.txtUf.setFont(new Font("",Font.BOLD,14));
		panelEnd.add(this.txtUf,FlowLayout.LEFT,7);
				
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
			try {
				if(f.isSelected()) {
					sexo=f.getText();
				}else if(m.isSelected()){
					sexo=m.getText();}
				
				CadastroController controller = new CadastroController();
				controller.cadastrarPessoa(this);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro: "+e1);
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
