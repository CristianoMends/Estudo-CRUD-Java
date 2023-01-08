package com.supermercado.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.supermercado.controller.CadastroController;
import com.supermercado.dao.CadastroDao;
import com.supermercado.model.Pessoa;

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
		setSize(1300,400);
		setLayout(new FlowLayout(FlowLayout.CENTER,110,5));
		
		modelo.addColumn("CPF");
		modelo.addColumn("NOME");
		modelo.addColumn("NASCIMENTO");
		modelo.addColumn("TELEFONE");
		modelo.addColumn("EMAIL");
		modelo.addColumn("SEXO");
		modelo.addColumn("RUA");
		modelo.addColumn("NUMERO");
		modelo.addColumn("UF");
		modelo.addRow(new Object[] {"CPF","NOME","NASCIMENTO","TELEFONE","E-MAIL","SEXO","RUA","NUMERO","UF"});
		
		tabela = new JTable(modelo);
		tabela.setPreferredSize(new Dimension(getWidth(),getHeight()-100));
		tabela.setFont(new Font("",Font.PLAIN,12));
		add(tabela,FlowLayout.CENTER,0);		
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(225,375,100,25);
		add(btnListar,FlowLayout.LEFT,1);
		btnListar.addActionListener(this);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(400,375,100,25);
		add(btnDeletar,FlowLayout.LEFT,2);
		btnDeletar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListar) {
			try {
			CadastroDao cadastroDao = new CadastroDao();
			lista = cadastroDao.listarPessoas();
			for (int i =0;i<lista.size();i++) {				
					
					modelo.addRow(new Object[] {						
							lista.get(i).getCpf(),
							lista.get(i).getNome(),
							lista.get(i).getNascimento(),
							lista.get(i).getTelefone(),
							lista.get(i).getEmail(),
							lista.get(i).getSexo(),
							lista.get(i).getRua(),
							lista.get(i).getNumero(),
							lista.get(i).getCidade(),
							lista.get(i).getUf()

					});
				
				}}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: "+erro);
			}
			
		}else if(e.getSource()==btnDeletar) {
			try {
				int a = JOptionPane.showConfirmDialog(btnDeletar, "Deseja deletar "+tabela.getValueAt(tabela.getSelectedRow(), 1));
				if(a==0) {
				CadastroController cadastroController = new CadastroController();
				cadastroController.deletarPessoa(this);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
				}
				
			} catch (SQLException e1 ) {
				JOptionPane.showMessageDialog(null, "Erro ao deletar");
				e1.printStackTrace();
			} catch(ArrayIndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar!");
			}
			
		}
	}

}
