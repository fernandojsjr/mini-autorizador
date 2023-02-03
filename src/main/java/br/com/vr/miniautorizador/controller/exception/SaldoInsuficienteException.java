package br.com.vr.miniautorizador.controller.exception;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String message) {
		super(message);
	}
	
	public SaldoInsuficienteException() {
		super();
	}
	
	

}
