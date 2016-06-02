package projetoFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Label extends JPanel{
	
	/*
	 * Cria o rodapé com a pontuação do jogador.
	 */
	private static int jogadas = 0, acertos = 0;
	static JLabel rotulo;
	
	public Label() {
		/*
		 * Dados do rótulo.
		 */
		
		rotulo = new JLabel("Remaining fowlers: " + Fowler.fowlers);
		rotulo.setForeground(Color.WHITE);
		
		this.add(rotulo);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(getWidth(),30));
	}
	/*
	 * Atualiza o número de jogadas.
	 */
	static protected void atualizar(int jogadas, int acertos){
		rotulo.setText("Remaining fowlers: " + Fowler.fowlers);
	}
	
	static protected void atualizarFowler(){
		rotulo.setText("Remaining fowlers: " + Fowler.fowlers);
	}
	
	/*
	 * Reinicia os contadores do jogo.
	 */
	
	static protected void resetar(){
		jogadas = 0;
		acertos = 0;
	}
	
}
