package com.cadastro.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cadastro.controller.CadastroController;
import com.cadastro.dao.CadastroDao;
import com.cadastro.model.Pessoa;

public class PainelLista extends JPanel implements ActionListener{
	JButton btnListar,btnDeletar;
	public JTable tabela;
	ArrayList<Pessoa> lista = new ArrayList<>();
	public DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;}};
			String txt = String.format("  COD %50s %50s %50s ","Nome","Nascimento","Telefone");
			
	public PainelLista() {
		setSize(700,400);
		setLayout(null);
		setBackground(Color.black);
		
		JLabel label = new JLabel(txt);
		label.setBounds(0, 0, 700, 25);
		add(label);
		
		modelo.addColumn("COD");
		modelo.addColumn("NOME");
		modelo.addColumn("NASCIMENTO");
		modelo.addColumn("TELEFONE");
		
		tabela = new JTable(modelo);
		tabela.setBounds(0,25,700,350);
		add(tabela);		
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(225,375,100,25);
		add(btnListar);
		btnListar.addActionListener(this);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(400,375,100,25);
		add(btnDeletar);
		btnDeletar.addActionListener(this);
		
		

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListar) {
			try {
			CadastroDao cadastroDao = new CadastroDao();
			lista = cadastroDao.listarPessoas();
			
			if(modelo.getRowCount() >= 0) {
				for(int a = 0;a < modelo.getRowCount() ;a++) {
					modelo.setNumRows(0);					
				}
			}
			
			for (int i =0;i<lista.size();i++) {				
				
					modelo.addRow(new Object[] {						
							lista.get(i).getCod(),
							lista.get(i).getNome(),
							lista.get(i).getDataNasc(),
							lista.get(i).getTelefone()							
					});
				
				}}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: "+erro);
			}
			
		}else if(e.getSource()==btnDeletar) {
			CadastroController cadastroController = new CadastroController();
			try {
				cadastroController.deletarPessoa(this);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao deletar");
				e1.printStackTrace();
			}
			
		}
	}

}
