package br.com.vr.miniautorizador.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.vr.miniautorizador.doman.Cartao;
import br.com.vr.miniautorizador.repository.CartaoRepository;

@SpringBootTest
class CartaoServiceImplTest {

	@Autowired
	CartaoService cartaoService;
	
	@Autowired
	CartaoRepository cartaoRepository;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}	
	
	@Test
	void testCriarNovoCartao() {
		//cartaoRepository.deleteAll();
		
		String numero = "12345678340123456";
		String senha = "123456";
		
		cartaoService.gerarCartao(numero, senha);
		Cartao cartao = cartaoService.findByNumeroAndSenha(numero, senha);
		
		assertNotNull(cartao.getId());
		assertEquals(numero, cartao.getNumero());
		assertEquals(senha, cartao.getSenha());
		assertEquals(500.00, cartao.getSaldo());
	}
	
	@Test
	void testObterSaldoCartao() {
		String numero = "1587421596854785";
		String senha = "1638";
		cartaoService.gerarCartao(numero, senha);
		Double saldo = cartaoService.consultaSaldoCartao(numero);
		assertEquals(500, saldo);
	}
	
	void testObterSaldoCartaoErro() {

	}
	
	@Test
	void testRealizarTransacao() {
		cartaoRepository.deleteAll();
		
		String numero = "135843138413513";
		String senha = "8601";
		Double valorTransacao = 10.32;

		cartaoService.gerarCartao(numero,senha);
		Double saldoAnterior = 500.00;
		cartaoService.realizarTransacao(numero, senha, valorTransacao);
		
		Double saldoCartao = cartaoService.consultaSaldoCartao(numero);
		Double saldoAtual = saldoAnterior - valorTransacao;
	
		
		assertEquals(saldoAnterior, 500.00);
		assertEquals(saldoAtual, saldoCartao);
	}
	
	@Test
	void testExcecaoCartaoSemSaldo() {
		cartaoRepository.deleteAll();
		
		String numero = "135843584383513";
		String senha = "8601";
		Double valorTransacao = 10.32;

		cartaoService.gerarCartao(numero,senha);
		Double saldoAnterior = 500.00;
		cartaoService.realizarTransacao(numero, senha, 300.00);
		cartaoService.realizarTransacao(numero, senha, 300.00);
		
		Double saldoCartao = cartaoService.consultaSaldoCartao(numero);
		Double saldoAtual = saldoAnterior - valorTransacao;
	
		
		assertEquals(saldoAnterior, 500.00);
		assertEquals(saldoAtual, saldoCartao);
	}	

}
