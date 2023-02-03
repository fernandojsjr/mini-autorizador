package br.com.vr.miniautorizador.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vr.miniautorizador.doman.Cartao;

public interface CartaoRepository extends MongoRepository<Cartao, String> {
	
	Optional<Cartao> findCartaoByNumero(String numero);
	Optional<Cartao> findByNumeroAndSenha(String numeroCartao, String senha);
	
}
