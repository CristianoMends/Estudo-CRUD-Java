package com.cadastro.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cadastro.dao.CadastroDao;
import com.cadastro.model.Pessoa;

public class PainelLista extends JPanel implements ActionListener{
	JButton btnListar;
	JTable tabela;
	DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;}};
			
	public PainelLista() {
		setSize(700,200);
		setLayout(new BorderLayout());
		
		btnListar = new JButton("Listar");
		add(BorderLayout.SOUTH,btnListar);
		btnListar.addActionListener(this);
		
		modelo.addColumn("COD");
		modelo.addColumn("NOME");
		modelo.addColumn("NASCIMENTO");
		modelo.addColumn("TELEFONE");

		tabela = new JTable(modelo);
		add(BorderLayout.CENTER,tabela);
		
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListar) {
			try {
			CadastroDao cadastroDao = new CadastroDao();
			
			ArrayList<Pessoa> lista = cadastroDao.listarPessoas();
			for (int i =0;i<lista.size();i++) {	
				
					modelo.addRow(new Object[] {						
							lista.get(i).getCod(),
							lista.get(i).getNome(),
							lista.get(i).getDataNasc(),
							lista.get(i).getTelefone()							
					});
				
				
				}
				
				
				
				
				

			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: "+erro);
			}
			
		}
	}

}
