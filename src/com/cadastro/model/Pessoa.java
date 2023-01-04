package com.cadastro.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private int cod;
	private String nome;
	private String dataNasc;
	private String telefone;
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public Pessoa() {
		}
	
	public Pessoa(int cod,String nome, String dataNasc, String telefone)  {
		this.cod = cod;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}
	public void cadastrarPessoa(Pessoa p) {
		pessoas.add(p);
	}
	public void deletarPessoa(Pessoa p) {
		pessoas.remove(p.getCod());
	}
	public List<Pessoa> listarPessoas() {
		
		return pessoas;
		
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
	public int getCod() {
		return cod;
	}
	public void setCod(int cod ) {
		this.cod = cod;
	}


	@Override
	public String toString() {
		
		return String.format("Cod: %3s Nome: %20s Nascimento: %10s Telefone: %12s \n" ,
				cod,nome,dataNasc,telefone);
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void addPessoa(Pessoa p) {
		pessoas.add(p);
	}

	
	

}
