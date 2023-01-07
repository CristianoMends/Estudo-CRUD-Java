package com.cadastro.controller;

import java.sql.SQLException;

import com.cadastro.dao.CadastroDao;
import com.cadastro.model.Pessoa;
import com.cadastro.view.CadastroView;
import com.cadastro.view.ListaView;

public class CadastroController {
	
	public CadastroController() {
		
	}
	public void cadastrarPessoa(CadastroView view ) throws SQLException {
		Pessoa pessoa = new Pessoa();
		CadastroDao cadastroDao = new CadastroDao();
		pessoa.setNome(view.txtNome.getText());
		pessoa.setDataNasc(view.txtDataNasc.getText());
		pessoa.setTelefone(view.txtTel.getText());
		cadastroDao.cadastrarPessoa(pessoa.getNome(), pessoa.getDataNasc(), pessoa.getTelefone());
		
	}
	public void deletarPessoa(ListaView listaView) throws SQLException {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.deletarPessoa((int)listaView.tabela.getValueAt(listaView.tabela.getSelectedRow(), 0));
		System.out.println(listaView.tabela.getValueAt(listaView.tabela.getSelectedRow(), 0));
		
	}
	
	
		
	
	
	

}
