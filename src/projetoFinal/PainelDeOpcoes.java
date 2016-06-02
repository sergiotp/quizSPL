package projetoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PainelDeOpcoes extends JPanel implements ActionListener{
static JPanel  painelDeOpcoes;
	
	public PainelDeOpcoes() {
		painelDeOpcoes = new JPanel();
		JButton buttonStart = new JButton("Ok, let's start !");
		buttonStart.setSize(20, 30);
		buttonStart.addActionListener(this);
		JButton buttonQuit = new JButton("No, please quit the game ?");
		buttonQuit.setSize(20, 30);
		buttonQuit.addActionListener(this);
		this.add(buttonStart);
		this.add(buttonQuit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando == "Ok, let's start !"){
			Frame frame = new Frame();
			frame.destruirPainel();
			frame.criarPainelDeConteudo("");
		}
		else if (comando == "No, please quit the game ?"){
			System.exit(0);
		}
		
	}
	
}
