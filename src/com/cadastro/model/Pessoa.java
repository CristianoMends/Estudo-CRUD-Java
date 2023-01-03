package com.cadastro.model;

public class Pessoa {
	private String nome;
	private String dataNasc;
	private String telefone;
	
	public Pessoa() {
		
	}	
	
	public void cadastrarPessoa(String nome, String dataNasc, String telefone) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", dataNasc=" + dataNasc + ", telefone=" + telefone + "]";
	}
	
	

}
