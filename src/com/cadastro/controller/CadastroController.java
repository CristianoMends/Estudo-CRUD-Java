package com.cadastro.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.cadastro.dao.CadastroDao;
import com.cadastro.model.Pessoa;
import com.cadastro.view.CadastroView;
import com.cadastro.view.ListaView;

public class CadastroController {
	
	SimpleDateFormat format = new SimpleDateFormat("dd/mm/aaaa");
	
	public CadastroController() {
		
	}
	public void cadastrarPessoa(CadastroView cadastroView) throws SQLException {
		Pessoa pessoa = new Pessoa();
		CadastroDao cadastroDao = new CadastroDao();
		pessoa.setNome(cadastroView.getTxtNome().getText());
		pessoa.setDataNasc(cadastroView.getTxtDataNasc().getText());
		pessoa.setTelefone(cadastroView.getTxtTel().getText());
		cadastroDao.cadastrarPessoa(pessoa.getNome(), pessoa.getDataNasc(), pessoa.getTelefone());
		
	}
	public void deletarPessoa(ListaView listaView) throws SQLException {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.deletarPessoa((int)listaView.tabela.getValueAt(listaView.tabela.getSelectedRow(), 0));
		System.out.println(listaView.tabela.getValueAt(listaView.tabela.getSelectedRow(), 0));
		
	} 
	
	
		
	
	
	

}
