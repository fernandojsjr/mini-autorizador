package br.com.vr.miniautorizador.dto;

import java.io.Serializable;

public class RetornoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String senha;
	
	public RetornoDTO() {
		
	}

	public RetornoDTO(String numero, String senha) {
		super();
		this.numero = numero;
		this.senha = senha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
