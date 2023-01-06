package com.cadastro.view;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cadastro.controller.CadastroController;


public class CadastroView extends JPanel implements KeyListener,ActionListener{
	private static final long serialVersionUID = 1L;
	int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	
	JTextField txtNome,txtTel,txtDataNasc;
	JButton btnCadastrar;
	ListaView listaView;	
	ImageIcon fundo = new ImageIcon(getClass().getResource("recursos/Fundo.png"));
	char[] letras = new char[15];
	
	
	public CadastroView() {
		letras[0] = '(';
		letras[3] = ')';
		letras[5] = ' ';
		letras[10] = '-';
		
		
		setSize(fundo.getIconWidth(),fundo.getIconHeight());
		setPreferredSize(new Dimension(fundo.getIconWidth(),fundo.getIconHeight()));
		setLayout(null);
		
		JPanel cadastroPanel = new JPanel();
		cadastroPanel.setBounds(50,200,300,400);
		cadastroPanel.setLayout(new FlowLayout(FlowLayout.LEADING,30,10));
		add(cadastroPanel);

		JLabel nome = new JLabel("Nome");
		nome.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(nome,FlowLayout.LEFT,0);
		
		txtNome = new JTextField(20);
		txtNome.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtNome,FlowLayout.LEFT,1);
		
		JLabel nasc = new JLabel("Nascimento");
		nasc.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(nasc,FlowLayout.LEFT,2);
		
		txtDataNasc = new JTextField(20);
		txtDataNasc.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtDataNasc,FlowLayout.LEFT,3);
		txtDataNasc.addKeyListener(this);
		
		JLabel tel = new JLabel("Telefone");
		tel.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(tel,FlowLayout.LEFT,4);
		
		txtTel = new JTextField(20);
		txtTel.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtTel,FlowLayout.LEFT,5);
		txtTel.addKeyListener(this);
		
		listaView = new ListaView();
		listaView.setBounds(400,200,700,400);
		add(listaView);
		
		btnCadastrar = new JButton("Cadastrar");
		cadastroPanel.add(btnCadastrar,FlowLayout.CENTER,6);
		btnCadastrar.addActionListener(this);
		
		JLabel fundo = new JLabel(this.fundo);
		fundo.setBounds(0,0,1300,800);
		add(fundo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		
			
		
		if(e.getSource()==btnCadastrar) {
			CadastroController controller = new CadastroController();
			try {
				txtDataNasc.setText(txtDataNasc.getText().formatted("dd/MM/yyyy"));
				controller.cadastrarPessoa(this);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastar!");
				e1.printStackTrace();
			}

		}
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public void setTxtTel(JTextField txtTel) {
		this.txtTel = txtTel;
	}

	public JTextField getTxtDataNasc() {
		return txtDataNasc;
	}

	public void setTxtDataNasc(JTextField txtDataNasc) {
		this.txtDataNasc = txtDataNasc;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Condicoes para Data de nascimento
		String key = String.valueOf(e.getKeyChar());
		if(!key.matches("[0-9]*")) {
			
		}
		
		if(e.getComponent()==txtDataNasc) {
		if(!txtDataNasc.getText().substring(0,txtDataNasc.getText().length()).matches("[0-9]*")) {			
			
		}
		
		if(txtDataNasc.getText().length()==2 ||txtDataNasc.getText().length()==5 ) {
			txtDataNasc.setText(txtDataNasc.getText()+"/");
		
		}
		
		if(txtDataNasc.getText().length()>=10) {
			txtDataNasc.setText(txtDataNasc.getText().substring(0,9));
		}}
	
		//Condicoes para telefone
		if(e.getComponent()==txtTel) {
			if(!txtTel.getText().substring(0,txtTel.getText().length()).matches("[0-9]*")) {
			}

		if(txtTel.getText().length()==0) {
			txtTel.setText(txtTel.getText()+letras[0]);
		}else if(txtTel.getText().length()==3) {
			txtTel.setText(txtTel.getText()+letras[3]);
		
		}else if(txtTel.getText().length()==5) {
			txtTel.setText(txtTel.getText()+letras[5]);
		
		}else if(txtTel.getText().length()==10) {
			txtTel.setText(txtTel.getText()+letras[10]);}
		}else {}
		if(txtTel.getText().length()>=14) {
			txtTel.setText(txtTel.getText().substring(0,14));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	
	

}
