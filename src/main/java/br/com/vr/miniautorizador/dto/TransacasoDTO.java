package br.com.vr.miniautorizador.dto;

import java.io.Serializable;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.Optional;

import br.com.vr.miniautorizador.doman.Cartao;

public class TransacasoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
		private String numeroCartao;
		private String senhaCartao;
		private Double valor;
		
		public TransacasoDTO() {
			
		}

		public TransacasoDTO(String numeroCartao, String senhaCartao, Double valor) {
			super();
			this.numeroCartao = numeroCartao;
			this.senhaCartao = senhaCartao;
			this.valor = valor;
		}

		public String getNumeroCartao() {
			return numeroCartao;
		}

		public void setNumeroCartao(String numeroCartao) {
			this.numeroCartao = numeroCartao;
		}

		public String getSenhaCartao() {
			return senhaCartao;
		}

		public void setSenhaCartao(String senhaCartao) {
			this.senhaCartao = senhaCartao;
		}

		public boolean isNaN() {
			return valor.isNaN();
		}

		public boolean isInfinite() {
			return valor.isInfinite();
		}

		public String toString() {
			return valor.toString();
		}

		public byte byteValue() {
			return valor.byteValue();
		}

		public short shortValue() {
			return valor.shortValue();
		}

		public int intValue() {
			return valor.intValue();
		}

		public long longValue() {
			return valor.longValue();
		}

		public float floatValue() {
			return valor.floatValue();
		}

		public double doubleValue() {
			return valor.doubleValue();
		}

		public int hashCode() {
			return valor.hashCode();
		}

		public boolean equals(Object obj) {
			return valor.equals(obj);
		}

		public int compareTo(Double anotherDouble) {
			return valor.compareTo(anotherDouble);
		}

		public Optional<Double> describeConstable() {
			return valor.describeConstable();
		}

		public Double resolveConstantDesc(Lookup lookup) {
			return valor.resolveConstantDesc(lookup);
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}		

}
