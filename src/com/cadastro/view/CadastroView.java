package com.cadastro.view;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cadastro.controller.CadastroController;


public class CadastroView extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	
	JTextField txtNome,txtTel,txtDataNasc;
	JButton btnCadastrar;
	PainelLista painelLista;	
	ImageIcon fundo = new ImageIcon(getClass().getResource("recursos/Fundo.png"));
	
	public CadastroView() {
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
		
		JLabel tel = new JLabel("Telefone");
		tel.setFont(new Font("",Font.BOLD,14));
		cadastroPanel.add(tel,FlowLayout.LEFT,4);
		
		txtTel = new JTextField(20);
		txtTel.setFont(new Font("",Font.BOLD,15));
		cadastroPanel.add(txtTel,FlowLayout.LEFT,5);
		
		painelLista = new PainelLista();
		painelLista.setBounds(400,200,700,400);
		add(painelLista);
		
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

	
	

}
