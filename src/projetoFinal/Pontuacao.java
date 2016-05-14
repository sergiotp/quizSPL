package projetoFinal;

public class Pontuacao {
	private String nomeJogador, numeroJogadas;
		
	protected Pontuacao(String nomeJogador, String numeroJogadas){
		this.nomeJogador = nomeJogador;
		this.numeroJogadas = numeroJogadas;
	}
	
	protected String getNome() {
		return this.nomeJogador;
	}
	
	protected int getNumeroJogadas() {
		return Integer.parseInt(this.numeroJogadas);
	}
}
