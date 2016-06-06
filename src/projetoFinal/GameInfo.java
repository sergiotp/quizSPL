package projetoFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GameInfo extends JPanel{
	
	/*
	 * Cria o rodapé com a pontuação do jogador.
	 */
	private static JTextArea  label;
	private static String infoText = "This game has 5 phases \r\n"
									+ "For each phase: \r\n"
									+ " -Guess the bad smell.\r\n"
									+ " -Choose the right smell characteristic \n"
									+ " -Choose the appropriate refactoring for the smell \n"
									+ "You have 5 chances ('Fowlers') to miss answers \n"
									+ "To receive 5 more Fowlers, answer true or false \n";
	
	public GameInfo() {						
		label = new JTextArea(infoText);	
		this.add(label);
		label.setEditable(false);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		label.setFont(label.getFont().deriveFont(18.0f));
		label.setBorder(BorderFactory.createEmptyBorder(10,50,10,350));
		label.setBackground(Color.LIGHT_GRAY);
		
		
		
	}

	static protected void atualizar(int jogadas, int acertos){
		label.setText("teste 2");
	}
	
	static public String getTextInfo(){
		return infoText;
	}
	
	
}
