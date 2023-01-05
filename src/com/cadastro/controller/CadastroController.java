package com.cadastro.controller;

import java.sql.SQLException;

import com.cadastro.dao.CadastroDao;
import com.cadastro.model.Pessoa;
import com.cadastro.view.CadastroView;
import com.cadastro.view.PainelLista;

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
	public void deletarPessoa(PainelLista painelLista) throws SQLException {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.deletarPessoa((int)painelLista.tabela.getValueAt(painelLista.tabela.getSelectedRow(), 0));
		System.out.println(painelLista.tabela.getValueAt(painelLista.tabela.getSelectedRow(), 0));
		
	} 
	
	
		
	
	
	

}
