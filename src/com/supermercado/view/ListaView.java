package com.supermercado.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.supermercado.controller.CadastroController;
import com.supermercado.dao.CadastroDao;
import com.supermercado.dao.Conexao;
import com.supermercado.model.entities.Pessoa;

public class ListaView extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JButton btnListar,btnDeletar,btnEditar;
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
		btnListar.setBounds(200,375,100,25);
		add(btnListar,FlowLayout.LEFT,1);
		btnListar.addActionListener(this);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(300,375,100,25);
		add(btnEditar,FlowLayout.LEFT,2);
		btnEditar.addActionListener(this);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(400,375,100,25);
		add(btnDeletar,FlowLayout.LEFT,3);
		btnDeletar.addActionListener(this);
		
		addMouseListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListar) {
			try {
			modelo.setRowCount(1);
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
				int a = JOptionPane.showConfirmDialog(btnDeletar, "Deseja deletar o cliente "+tabela.getValueAt(tabela.getSelectedRow(), 1));
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
			
		}	else if(e.getSource()==btnEditar) {
			try {
				int a = JOptionPane.showConfirmDialog(btnEditar, "Deseja Editar o cliente "+tabela.getValueAt(tabela.getSelectedRow(), 1));
				if(a==0) {
				JFrame frame = new JFrame("Edição de cliente");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);				
				frame.setResizable(false);
				
				CadastroView cadastroView = new CadastroView();
				cadastroView.btnCadastrar.setText("Atualizar");
				frame.add(cadastroView);
				frame.pack();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				
				Connection conexao = new Conexao().getConnection();
				Statement st = conexao.createStatement();
				String cpf = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
				String sql = "SELECT * FROM cliente where cpf = '"+cpf+"'";
				ResultSet rs = st.executeQuery(sql);
				
				while (rs.next()) {
				
				cadastroView.txtCidade.setText(rs.getString("cidade"));
				cadastroView.txtCpf.setText(rs.getString("cpf"));
				cadastroView.txtDataNasc.setText(rs.getString("nascimento"));
				cadastroView.txtEmail.setText(rs.getString("email"));
				cadastroView.txtNome.setText(rs.getString("nome"));
				cadastroView.txtNumero.setText(rs.getString("numero"));
				cadastroView.txtRua.setText(rs.getString("rua"));
				cadastroView.txtTel.setText(rs.getString("telefone"));
				cadastroView.txtUf.setText(rs.getString("uf"));
				
				
				}
				
				
				}
				
				}catch(SQLException e3) {}
			
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==3) {
			JPopupMenu p = new JPopupMenu();
			
			
			p.add(new JMenuItem("Editar"));
			p.add(new JMenuItem("Deletar"));

			
			p.show(this, e.getX(), e.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
