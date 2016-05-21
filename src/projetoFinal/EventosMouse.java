package projetoFinal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosMouse extends MouseAdapter {

	Pergunta pergunta;

	protected EventosMouse(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public void mouseClicked(MouseEvent e) {
		/*
		 * Aqui será selecionada a pergunta no RadioButton.
		 */
		
	}
}
