package com.cadastro.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class ListaView extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton btnListar,btnDeletar;
	public JTable tabela;
	ArrayList<Pessoa> lista = new ArrayList<>();
	public DefaultTableModel modelo = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;}};
			
	public ListaView() {
		setSize(1000,400);
		setLayout(new FlowLayout(FlowLayout.CENTER,110,5));
		
		modelo.addColumn("COD");
		modelo.addColumn("NOME");
		modelo.addColumn("NASCIMENTO");
		modelo.addColumn("TELEFONE");
		
		JLabel cod = new JLabel("COD");
		cod.setFont(new Font("",Font.BOLD,14));
		add(cod,FlowLayout.LEFT,0);
		
		JLabel nome = new JLabel("Nome");
		nome.setFont(new Font("",Font.BOLD,14));
		add(nome,FlowLayout.LEFT,1);

		JLabel nasc = new JLabel("Nascimento");
		nasc.setFont(new Font("",Font.BOLD,14));
		add(nasc,FlowLayout.LEFT,2);

		JLabel telefone = new JLabel("Telefone");
		telefone.setFont(new Font("",Font.BOLD,14));
		add(telefone,FlowLayout.LEFT,3);
		
		tabela = new JTable(modelo);
		tabela.setPreferredSize(new Dimension(getWidth(),getHeight()-100));
		tabela.setFont(new Font("",Font.BOLD,12));
		add(tabela,FlowLayout.CENTER,4);		
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(225,375,100,25);
		add(btnListar,FlowLayout.LEFT,5);
		btnListar.addActionListener(this);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(400,375,100,25);
		add(btnDeletar,FlowLayout.LEFT,6);
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
			try {
			CadastroController cadastroController = new CadastroController();
			
				cadastroController.deletarPessoa(this);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
				
			} catch (SQLException e1 ) {
				JOptionPane.showMessageDialog(null, "Erro ao deletar");
				e1.printStackTrace();
			} catch(ArrayIndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar!");
			}
			
		}
	}

}
