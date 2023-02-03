package br.com.vr.miniautorizador.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.beans.Expression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.vr.miniautorizador.dto.NovoCartaoDTO;
import br.com.vr.miniautorizador.service.CartaoService;

@SpringBootTest
@AutoConfigureMockMvc
class CartaoControllerTest {
	
	static String BASE_API = "/api/autorizador/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	
	@Autowired
	MockMvc mvc;
	
	@Autowired
	CartaoService cartaoService;
	
	@Test
	@DisplayName("Deve gerar um novo cartao")
	public void gerarCartao() throws Exception {
		
		NovoCartaoDTO cartaoDTO = new NovoCartaoDTO("1234567890123456", "1203");
		
		String json = new ObjectMapper().writeValueAsString(cartaoDTO);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.post("/cartoes")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(json);
		
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated() )
		.andExpect(jsonPath("numero").isNotEmpty())
		.andExpect(jsonPath("senha").value("1203"));
		
	}

}
