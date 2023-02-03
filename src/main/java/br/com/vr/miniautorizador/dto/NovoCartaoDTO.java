package br.com.vr.miniautorizador.dto;

import java.io.Serializable;

import br.com.vr.miniautorizador.doman.Cartao;

public class NovoCartaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String senha;
	
	public NovoCartaoDTO() {
		
	}

	public NovoCartaoDTO(String numero, String senha) {
		super();
		this.numero = numero;
		this.senha = senha;
	}

	public NovoCartaoDTO(Cartao cartao) {
		this.numero = cartao.getNumero();
		this.senha = cartao.getSenha();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
