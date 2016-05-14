package projetoFinal;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PainelDeImagem extends JPanel{
	int numero;
	
	/*
	 * Imagem para ficar na parte de trás.
	 */
	ImageIcon imagemTraseira;
	ArrayList<Imagem> imagens = new ArrayList<Imagem>();
	/*
	 * Nível de dificuldade do jogo.
	 */
	private int nivelDeDificuldade;
	public PainelDeImagem(String dificuldade){
		this.setBackground(Color.DARK_GRAY);
		/*
		 * Adiciona quatro colunas e quantas linhas forem necessárias conforme
		 * documentação da oracle.
		 */
		this.setLayout(new GridLayout(0,4));
		if(dificuldade =="Normal"){
			this.nivelDeDificuldade = 9;
			imagemTraseira = new ImageIcon("imagens1/PM.png");
		}
		else{
			this.nivelDeDificuldade = 17;
			imagemTraseira = new ImageIcon("imagens2/PM.png");
		}
		this.criarImagens(nivelDeDificuldade);
		
	}
	/*
	 * Falta um arraylist para adicionar e embaralhar as imagens.
	 */
	public void criarImagens(int nivelDeDificuldade){
		for(int i = 1; i < nivelDeDificuldade; i++){
			Imagem img1 = new Imagem(i,"a.png" , imagemTraseira,nivelDeDificuldade);
			Imagem img2 = new Imagem(i,"b.png" , imagemTraseira,nivelDeDificuldade);
			this.imagens.add(img1);
			this.imagens.add(img2);
			
		}
		this.embaralharImagens();
		for(int i = 0;i<this.imagens.size();i++){
			this.add(imagens.get(i));
		}
		this.imagens.get(0).atualizar();
	}
	
	protected int inteiroRandomico(int minimo, int maximo) {
		Random rand = new Random();
		int numeroRandomico = rand.nextInt((maximo - minimo) + 1) + minimo;
		return numeroRandomico;
	}
	
	/*
	 * Embaralha o baralho. Cria um baralho auxiliar e o embaralha.
	 */

	protected void embaralharImagens(){
		ArrayList<Imagem> imagensAuxiliar = new ArrayList<Imagem>();
		int aux;
		while(this.imagens.size() > 0) {
			aux = inteiroRandomico(0, imagens.size() - 1);
			Imagem auxiliar = imagens.remove(aux);
			imagensAuxiliar.add(auxiliar);
		}

		this.imagens = imagensAuxiliar;
	}
		
}
