package br.com.vr.miniautorizador;

public class HelloWorld {

	public static void main(String[] args) {

		int min = 100;
		int max = 1000;
		
		String numeracaoInicial = "6549873025634";
		
		int sequencia = (int)Math.floor(Math.random() * (max - min + 1) + min);
		
	
		System.out.println(numeracaoInicial + sequencia);
		
	}

}
