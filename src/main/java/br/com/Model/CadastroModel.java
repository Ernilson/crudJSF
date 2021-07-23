package br.com.Model;

import java.io.Serializable;

public class CadastroModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8230086132255051998L;
	
	private int id;
	private String nome;
	private String endereco;
	private String fone;
	private String email;	
	
	public CadastroModel() {
		// TODO Auto-generated constructor stub
	}
	

	public CadastroModel(int id, String nome, String endereco, String fone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.fone = fone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroModel other = (CadastroModel) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CadastroModel [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", fone=" + fone + ", email="
				+ email + "]";
	}
	
	


}