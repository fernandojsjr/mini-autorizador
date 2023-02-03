package br.com.vr.miniautorizador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vr.miniautorizador.doman.Cartao;
import br.com.vr.miniautorizador.dto.NovoCartaoDTO;
import br.com.vr.miniautorizador.dto.TransacasoDTO;
import br.com.vr.miniautorizador.service.CartaoService;

@RestController
public class CartaoController {
	
	@Autowired
	private CartaoService cartaoService;
	
	@PostMapping(value="/cartoes")
	@ResponseStatus(HttpStatus.CREATED)
	public NovoCartaoDTO gerarCartao(@RequestBody NovoCartaoDTO novoCartaoDTO ) {
		cartaoService.gerarCartao(novoCartaoDTO.getNumero(), novoCartaoDTO.getSenha());
		return novoCartaoDTO;
	}
	
	@GetMapping(value="cartoes/{numeroCartao}")
	public Double obterSaldo(@PathVariable(value = "numeroCartao") String numeroCartao ) {
		 return cartaoService.consultaSaldoCartao(numeroCartao);
	}
	
	@PostMapping(value="/transacoes")
	public TransacasoDTO realizarTransacao(@RequestBody TransacasoDTO transacao) {
		return cartaoService.realizarTransacao(transacao.getNumeroCartao(), transacao.getSenhaCartao(), transacao.getValor());
	}

}
