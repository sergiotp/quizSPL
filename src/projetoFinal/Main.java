package projetoFinal;

public class Main {

	public static void main(String[] args) {
		/*
		 * Conforme documentação da oracle, a invocação padrão abaixo
		 * é utilizada para a thread despachadora de eventos:
		 *  Ela cria e mostra a GUI da aplicação.
		 */
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	               Jogo.showGUI();
	            }
	        }); 
	}

}
