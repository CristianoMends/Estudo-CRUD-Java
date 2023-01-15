package com.supermercado.view;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.supermercado.controller.CadastroController;
import com.supermercado.dao.CadastroDao;
import com.supermercado.dao.Conexao;
import com.supermercado.model.entities.Pessoa;

public class ListaView extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private JButton btnListar, btnDeletar, btnEditar, btnPesquisar;
	public static JTable tabela;
	ArrayList<Pessoa> lista = new ArrayList<>();
	public DefaultTableModel modelo = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	};

	public ListaView() {
		setSize(1300, 400);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

		modelo.addColumn("CPF");
		modelo.addColumn("NOME");
		modelo.addColumn("NASCIMENTO");
		modelo.addColumn("TELEFONE");
		modelo.addColumn("EMAIL");
		modelo.addColumn("SEXO");
		modelo.addColumn("RUA");
		modelo.addColumn("NUMERO");
		modelo.addColumn("UF");
		

		tabela = new JTable(modelo);
		tabela.setFont(new Font("", Font.PLAIN, 12));
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setPreferredSize(new Dimension(getWidth(), getHeight()-50));
		add(scroll);
		
		btnPesquisar = new JButton("Pesquisar");
		add(btnPesquisar);
		btnPesquisar.addActionListener(this);

		btnListar = new JButton("Listar");
		add(btnListar);
		btnListar.addActionListener(this);

		btnEditar = new JButton("Editar");
		add(btnEditar);
		btnEditar.addActionListener(this);

		btnDeletar = new JButton("Deletar");
		add(btnDeletar);
		btnDeletar.addActionListener(this);

		addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			try {
				CadastroDao cadastroDao = new CadastroDao();
				lista = cadastroDao.listarPessoas();
				for (int i = 0; i < lista.size(); i++) {
					modelo.addRow(new Object[] { lista.get(i).getCpf(), lista.get(i).getNome(),
							lista.get(i).getNascimento(), lista.get(i).getTelefone(), lista.get(i).getEmail(),
							lista.get(i).getSexo(), lista.get(i).getRua(), lista.get(i).getNumero(),
							lista.get(i).getCidade(), lista.get(i).getUf()

					});

				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
		} else if (e.getSource() == btnDeletar) {
			try {
				int a = JOptionPane.showConfirmDialog(btnDeletar,
						"Deseja deletar o cliente " + tabela.getValueAt(tabela.getSelectedRow(), 1));
				if (a == 0) {
					CadastroController cadastroController = new CadastroController();
					cadastroController.deletarPessoa(this);
					JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
				}

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao deletar");
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar!");
			}

		}else if(e.getSource()==btnPesquisar) {
			String key = JOptionPane.showInputDialog(btnPesquisar,"Digite um nome para pesquisar");
			
		}else if (e.getSource() == btnEditar) {
			try {
						
				
				int a = JOptionPane.showConfirmDialog(btnEditar,
						"Deseja Editar o cliente " + tabela.getValueAt(tabela.getSelectedRow(), 1));
				if (a == 0) {
					JFrame frame = new JFrame("Edição de cliente");
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setResizable(false);
					CadastroView cadastroView = new CadastroView();
					cadastroView.btnCadastrar.setText("Atualizar");
					frame.add(cadastroView);
					Connection conexao = new Conexao().getConnection();
					Statement st = conexao.createStatement();
					String cpf = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
					String sql = "SELECT * FROM cliente where cpf = '" + cpf + "'";
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

					frame.pack();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(tabela, "Selecione uma tabela!");
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 3) {
			JPopupMenu p = new JPopupMenu();

			p.add(new JMenuItem("Editar"));
			p.add(new JMenuItem("Deletar"));

			p.show(this, e.getX(), e.getY());
		}
	}
	public static String getSelectedCpf() {
		return tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
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
