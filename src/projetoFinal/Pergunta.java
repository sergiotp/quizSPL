package projetoFinal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pergunta extends JLabel implements ActionListener{

	ImageIcon imagemFrente, imagemTraseira;
	private int numero;
	private String caminhoImagem;
	private boolean paraCima = false;
	static ArrayList<Pergunta> numeroDeViradas = new ArrayList<Pergunta>();
	private static int numeroDeTentativas = 0, numeroDeAcertos = 0, dificuldade = 0;
	private static String nomeJogador;
	private String sequencial;
	private Timer contador;
	
	/*
	 * https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
	 */

	public Pergunta(int numero, String sequencial, ImageIcon imagemTraseira, int nivelDeDificuldade) {
		super(imagemTraseira);
		dificuldade = nivelDeDificuldade - 1;
		this.sequencial = sequencial;
		if(nivelDeDificuldade == 9)
			caminhoImagem = "imagens1/" + numero + sequencial;
		else
			caminhoImagem = "imagens2/" + numero + sequencial;
		
		try {
			this.imagemFrente = new ImageIcon(caminhoImagem);
			
			this.numero = numero;
			this.imagemTraseira = imagemTraseira;
			/*
			 * Adiciona um mouselistener a esta imagem específica.
			 */
			this.addMouseListener(new EventosMouse(this));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	protected void virarImagem(){
		if(this.getVirada())
			return;
		this.setVirada(true);
		this.setIcon(this.imagemFrente);
		numeroDeViradas.add(this);
	}
	
	protected int imagensViradas(){
		return numeroDeViradas.size();
	}
	
	protected int getNumeroVirada(){
		return numeroDeViradas.get(0).getNumero();
	}
	protected String getSequencialVirada(){
		return numeroDeViradas.get(0).getSequencial();
	}
	
	protected void verificarIguais(){
		if( this.imagensViradas() == 2){
		if(numeroDeViradas.get(0).getNumero() != numeroDeViradas.get(1).getNumero()){
			numeroDeTentativas++;
			Label.atualizar(numeroDeTentativas, numeroDeAcertos);
			this.tempo();
		}else{
			numeroDeTentativas++;
			numeroDeAcertos++;
			Label.atualizar(numeroDeTentativas, numeroDeAcertos);
			if(numeroDeAcertos == dificuldade){
				nomeJogador = JOptionPane.showInputDialog(this, "Parabéns, você venceu com " + numeroDeTentativas + " tentativas!\n" + "Digite o seu nome: ");
				
				if(nomeJogador == null){
					numeroDeViradas.clear();
					this.atualizar();
					return;
				}
				nomeJogador = nomeJogador.replaceAll("\\s+","_");
				Jogo.inserirPontuacao(nomeJogador, numeroDeTentativas, dificuldade);
				this.atualizar();
				Label.resetar();
			}
			numeroDeViradas.clear();
			
		}
		}
	}
	
	protected void setVirada(boolean virada){
		this.paraCima = virada;
	}
	protected boolean getVirada(){
		return this.paraCima;
	}
	
	
	protected int getNumero(){
		return this.numero;
	}
	
	protected String getSequencial(){
		return this.sequencial;
	}
	
	protected void tempo(){
		contador = new Timer(1000, this);
		contador.setRepeats(false);
		contador.start();
	}
	
	protected void atualizar(){
		numeroDeAcertos = 0;
		numeroDeTentativas = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < numeroDeViradas.size();i++){
			numeroDeViradas.get(i).setVirada(false);
			numeroDeViradas.get(i).setIcon(imagemTraseira);
		}
		numeroDeViradas.clear();
	}
	
}
