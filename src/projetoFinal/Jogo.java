package projetoFinal;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Jogo extends JPanel {
	
	private static ArrayList<Pontuacao> ranking;
	private static String [] split;
	
	private static int dificuldade;

	protected static void mostrarGUI() {
		@SuppressWarnings("unused")
		JFrame jogo = new Frame();
	}
	/*
	 * Lê os dados do arquivo.
	 */

	protected static ArrayList<String> lerArquivo(){
		ArrayList<String> linhas = new ArrayList<String>();
		String linha;
		Scanner in = null;
		String arquivo;
		if(dificuldade == 8)
			arquivo = "rankingNormal.txt";
		else
			arquivo = "rankingDificil.txt";
		try {
			in = new Scanner(new FileReader(arquivo));
			while (in.hasNext()) {
				linha = in.next();
				linhas.add(linha);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			in.close();
		}
		return linhas;
	}
	
	/*
	 * Insere a pontuação do jogador de acordo com o nível de dificuldade.
	 */
	protected static void inserirPontuacao(String nomeJogador, int numeroDeTentativas, int nivelDificuldade){
		dificuldade(nivelDificuldade);		
		ranking = montarRanking();
		for(int i = 0;i < ranking.size();i++){
			if(ranking.get(i).getNumeroJogadas() >= numeroDeTentativas){
				String pontos = String.valueOf(numeroDeTentativas);
				Pontuacao aux = new Pontuacao(nomeJogador, pontos);
				ranking.add(i,aux);
				ranking.remove(5);
				break;
			}
		}
		escreverArquivo(ranking);
	}
	/*
	 * Monta o ranking com os dados do arquivo.
	 */
	protected static ArrayList<Pontuacao> montarRanking(){
		ArrayList<String> linhas = Jogo.lerArquivo();
		ArrayList<Pontuacao>rankingAuxiliar = new ArrayList<Pontuacao>();
		for(String l:linhas){
			split = l.split(";");
			rankingAuxiliar.add(new Pontuacao(split[0], split[1]));
		}
		return rankingAuxiliar;
	}
	/*
	 * Escreve a pontuação no arquivo. 
	 */
	
	protected static void escreverArquivo(ArrayList<Pontuacao> pontos){
		PrintWriter escrita = null;
		String nomeArquivo;
		if(dificuldade ==8)
			nomeArquivo = "rankingNormal.txt";
		else
			nomeArquivo = "rankingDificil.txt";
		try{
				escrita = new PrintWriter(nomeArquivo);
				for(Pontuacao pont:pontos){
					escrita.printf("%s%s%s\n",pont.getNome(),";",pont.getNumeroJogadas());
				}
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				escrita.close();
			}
		}
	protected static void dificuldade(int nivelDificuldade){
		dificuldade = nivelDificuldade;
	}
	
}
