package projetoFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComoJogar extends JPanel{
	
	/*
	 * Cria o rodapé com a pontuação do jogador.
	 */
	static JLabel rotulo;
	
	public ComoJogar() {
		/*
		 * Dados do rótulo.
		 */
				
		
		rotulo = new JLabel("This game has 5 phases \n"
				+ "For each phase: \n"
				+ " -Guess the bad smell.\n"
				+ " -Choose the right smell characteristic \n"
				+ " -Choose the appropriate refactoring for the smell \n"
				+ "You have 5 chances ('Fowlers') to miss answers \n"
				+ "To receive 5 more Fowlers, answer true or false \n");
		rotulo.setForeground(Color.WHITE);
		
		this.add(rotulo);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		//this.setPreferredSize(new Dimension(getWidth(),30));
	}

	static protected void atualizar(int jogadas, int acertos){
		rotulo.setText("teste 2");
	}
	
	
}
