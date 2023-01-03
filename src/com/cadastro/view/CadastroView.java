package com.cadastro.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cadastro.controller.CadastroController;
import com.cadastro.dao.CadastroDao;


public class CadastroView extends JPanel implements ActionListener{
	int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	JTextField txtNome,txtTel,txtDataNasc;
	JTextArea txtCampo;
	JButton btnCadastrar,btnListar,btnDeletar;
	private int cod;
	
	
	public CadastroView() {
		setSize(largura,altura);
		setPreferredSize(new Dimension(500,500));
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
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(200,400,100,25);
		add(btnListar);
		btnListar.addActionListener(this);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(200,450,100,25);
		add(btnDeletar);
		btnDeletar.addActionListener(this);
		
		txtCampo = new JTextArea();
		txtCampo.setBounds(400,200,500,125);
		txtCampo.setEnabled(false);
		txtCampo.setLineWrap(true);
		txtCampo.setBackground(Color.black);
		add(txtCampo);
		
		
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

		}else if(e.getSource()==btnListar) {
			CadastroController controller = new CadastroController();
			try {
				setTxtCampo(controller.listarPessoas());
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()==btnDeletar) {
			CadastroController controller = new CadastroController();
			try {
				setCod( Integer.parseInt(JOptionPane.showInputDialog("Digite o código a ser deletado!")));
				controller.deletarPessoa(this);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao deletar!");
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

	public JTextArea getTxtCampo() {
		return txtCampo;
	}
	public void setTxtCampo(String txt) {
		this.txtCampo.setText(txt);
	}
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

}
