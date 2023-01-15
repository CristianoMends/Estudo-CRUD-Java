package com.supermercado.controller;

import java.sql.SQLException;

import com.supermercado.dao.CadastroDao;
import com.supermercado.model.entities.Pessoa;
import com.supermercado.view.CadastroView;
import com.supermercado.view.ListaView;

public class CadastroController {
	
	public CadastroController() {
		
	}
	public void cadastrarPessoa(CadastroView view ) throws SQLException {
		Pessoa pessoa = new Pessoa();
		CadastroDao cadastroDao = new CadastroDao();
		pessoa.setCpf(view.txtCpf.getText());
		pessoa.setNome(view.txtNome.getText());
		pessoa.setNascimento(view.txtDataNasc.getText());
		pessoa.setTelefone(view.txtTel.getText());
		pessoa.setEmail(view.txtEmail.getText());
		pessoa.setSexo(view.sexo);
		pessoa.setRua(view.txtRua.getText());
		pessoa.setNumero(view.txtNumero.getText());
		pessoa.setCidade(view.txtCidade.getText());
		pessoa.setUf(view.txtUf.getText());
		
		cadastroDao.cadastrarPessoa(
		pessoa.getCpf(),pessoa.getNome(), pessoa.getNascimento(),pessoa.getTelefone(), pessoa.getEmail(),pessoa.getSexo(),
		pessoa.getRua(),pessoa.getNumero(),pessoa.getCidade(),pessoa.getUf());
		
	}
	public void deletarPessoa(ListaView listaView) throws SQLException {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.deletarPessoa(listaView.tabela.getValueAt(listaView.tabela.getSelectedRow(), 0).toString());
		
	}
	public void editarPessoa(CadastroView view) throws SQLException {
		Pessoa pessoa = new Pessoa();
		CadastroDao cadastroDao = new CadastroDao();
		
		pessoa.setCpf(view.txtCpf.getText());
		pessoa.setNome(view.txtNome.getText());
		pessoa.setNascimento(view.txtDataNasc.getText());
		pessoa.setTelefone(view.txtTel.getText());
		pessoa.setEmail(view.txtEmail.getText());
		pessoa.setSexo(view.sexo);
		pessoa.setRua(view.txtRua.getText());
		pessoa.setNumero(view.txtNumero.getText());
		pessoa.setCidade(view.txtCidade.getText());
		pessoa.setUf(view.txtUf.getText());
		
		cadastroDao.atualizarPessoa(
		pessoa.getCpf(),pessoa.getNome(), pessoa.getNascimento(),
		pessoa.getEmail(), pessoa.getRua(), pessoa.getNumero(),
		pessoa.getCidade(), pessoa.getUf(), pessoa.getSexo(), pessoa.getSexo(),
		ListaView.getSelectedCpf());
		
	}
	
	
		
	
	
	

}
