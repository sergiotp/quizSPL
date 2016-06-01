package projetoFinal;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PainelDeOpcoes extends JPanel {
static JPanel  painelDeOpcoes;
	
	public PainelDeOpcoes() {
		painelDeOpcoes = new JPanel();
		JButton buttonStart = new JButton("Ok, let's start !");
		buttonStart.setSize(20, 30);
		JButton buttonQuit = new JButton("No, please quit the game ?");
		buttonQuit.setSize(20, 30);
		this.add(buttonStart);
		this.add(buttonQuit);
	}
	
}
