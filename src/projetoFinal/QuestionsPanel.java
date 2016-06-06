package projetoFinal;

import javax.swing.JPanel;

public class QuestionsPanel implements Panel {

	@Override
	public JPanel draw() {
		return new PainelDePerguntas();
	}

}
