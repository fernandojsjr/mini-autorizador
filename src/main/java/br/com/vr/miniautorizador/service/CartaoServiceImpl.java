package br.com.vr.miniautorizador.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vr.miniautorizador.controller.exception.SaldoInsuficienteException;
import br.com.vr.miniautorizador.doman.Cartao;
import br.com.vr.miniautorizador.dto.TransacasoDTO;
import br.com.vr.miniautorizador.repository.CartaoRepository;

@Service
public class CartaoServiceImpl implements CartaoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CartaoRepository cartaoReposiory;

	@Override
	public Double consultaSaldoCartao(String numeroCartao) {
		return this.cartaoReposiory.findCartaoByNumero(numeroCartao)
				.orElseThrow( RuntimeException::new ).getSaldo();
	}

	@Override
	public TransacasoDTO realizarTransacao(String numeroCartao, String senha, Double valor) {
		TransacasoDTO transacasoDTO = cartaoReposiory.findByNumeroAndSenha(numeroCartao, senha).map( (c) -> {
			Double saldo = this.consultaSaldoCartao(c.getNumero());
			System.out.println(saldo);
			if(saldo < valor) throw new SaldoInsuficienteException();
			c.setSaldo((saldo - valor));
			cartaoReposiory.save(c);
			return new TransacasoDTO(c.getNumero(), c.getSenha(), valor);
		})
				.orElseThrow(RuntimeException::new);
		
		
		return transacasoDTO;
	}

	@Override
	public Cartao gerarCartao(String numero, String senha) {
		cartaoReposiory.findByNumeroAndSenha(numero, senha).ifPresentOrElse((x) -> new RuntimeException(), () -> {
			Cartao cartao = new Cartao(null, numero, senha, 500.00 );
			cartaoReposiory.save(cartao);
		});
		
		return cartaoReposiory.findByNumeroAndSenha(numero, senha).get();
	}		

	@Override
	public Cartao findCartaoByNumero(String numero) {
		return cartaoReposiory.findCartaoByNumero(numero).get();
	}

	@Override
	public Cartao findByNumeroAndSenha(String numeroCartao, String senha) {
		return cartaoReposiory.findByNumeroAndSenha(numeroCartao, senha).get();
	}

}
