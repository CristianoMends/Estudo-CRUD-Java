package com.cadastro.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tela extends JPanel implements ActionListener{
	int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	JTextField txtNome,txtTel,txtDataNasc;
	JTextArea txtCampo;
	JButton btnCadastrar;
	
	public Tela() {
		setPreferredSize(new Dimension(largura,altura));
		setLayout(null);
		
		JLabel nome = new JLabel("Nome");
		nome.setBounds(50,200,50,25);
		add(nome);
		
		txtNome = new JTextField();
		txtNome.setBounds(150,200,200,25);
		add(txtNome);
		
		JLabel nasc = new JLabel("Nascimento");
		nasc.setBounds(50,250,100,25);
		add(nasc);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(150,250,200,25);
		add(txtDataNasc);
		
		JLabel tel = new JLabel("Telefone");
		tel.setBounds(50,300,100,25);
		add(tel);
		
		txtTel = new JTextField();
		txtTel.setBounds(150,300,200,25);
		add(txtTel);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(200, 350, 100, 25);
		add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
		txtCampo = new JTextArea();
		txtCampo.setBounds(400,200,400,125);
		txtCampo.setEditable(false);
		txtCampo.setBackground(Color.black);
		add(txtCampo);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCadastrar) {
			String texto = String.format("Nome: %s\nNascimento: %s\nTelefone: %s",
					getTxtNome().getText(),getTxtDataNasc().getText(),getTxtTel().getText());
			txtCampo.setText(texto);
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

	public JTextArea getTxtCampo() {
		return txtCampo;
	}
	public void setTxtCampo(JTextArea txtCampo) {
		this.txtCampo = txtCampo;
	}
}
