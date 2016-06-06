package projetoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel implements Panel, ActionListener {

	static JPanel  painelDeOpcoes;
	static private String startText = "Ok, let's start !";
	static private String quitText = "No, please quit the game ?";
	
	public OptionsPanel() {
		painelDeOpcoes = new JPanel();
		JButton buttonStart = new JButton(startText);
		buttonStart.setSize(20, 30);
		buttonStart.addActionListener(this);
		JButton buttonQuit = new JButton(quitText);
		buttonQuit.setSize(20, 30);
		buttonQuit.addActionListener(this);
		this.add(buttonStart);
		this.add(buttonQuit);
	}
	
	@Override
	public JPanel draw() {
		// TODO Auto-generated method stub
		return new OptionsPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando == startText){
			Frame frame = new Frame();
			frame.destruirPainel();
			frame.criarPainelDeConteudo("");
		}
		else if (comando == quitText){
			System.exit(0);
		}
		
	}

}
