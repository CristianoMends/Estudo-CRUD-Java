package com.supermercado.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private String cpf;
	private String nome;
	private String nascimento;
	private String telefone;
	private String email,rua,cidade,uf,sexo,numero;
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public Pessoa() {
		}
	
	public Pessoa(String cpf,String nome, String dataNasc, String telefone)  {
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = dataNasc;
		this.telefone = telefone;
	}
	public void cadastrarPessoa(Pessoa p) {
		pessoas.add(p);
	}
	public void deletarPessoa(String p) {
		pessoas.remove(pessoas.indexOf(p));
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf ) {
		this.cpf = cpf;
	}
	

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public String toString() {
		
		return String.format("Cod: %3s Nome: %20s Nascimento: %10s Telefone: %12s \n" ,
				cpf,nome,nascimento,telefone);
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void addPessoa(Pessoa p) {
		pessoas.add(p);
	}

	
	

}
