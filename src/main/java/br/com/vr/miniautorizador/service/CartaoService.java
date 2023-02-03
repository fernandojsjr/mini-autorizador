package br.com.vr.miniautorizador.service;

import br.com.vr.miniautorizador.doman.Cartao;
import br.com.vr.miniautorizador.dto.TransacasoDTO;

public interface CartaoService {

	Double consultaSaldoCartao(String numeroCartao);
	TransacasoDTO realizarTransacao(String numeroCartao, String senha, Double valor);
	Cartao gerarCartao(String numero, String senha);
	
	Cartao findCartaoByNumero(String numero);
	Cartao findByNumeroAndSenha(String numeroCartao, String senha);
	
	
}
