package com.cadastro.controller;

import java.sql.SQLException;

import com.cadastro.dao.CadastroDao;
import com.cadastro.model.Pessoa;
import com.cadastro.view.CadastroView;

public class CadastroController {
	
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
	public void deletarPessoa(CadastroView cadastroView) throws SQLException {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.deletarPessoa(cadastroView.getCod());
		
	} 
	public String listarPessoas() throws SQLException {
		CadastroDao cadastroDao = new CadastroDao();
		return cadastroDao.listarPessoas();
		
		
	}
	
	

}
