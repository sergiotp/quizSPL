package businessPack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageReadParam;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Questions extends JLabel implements ActionListener {
	
	private String [] split;
	private String correctAnswer, selected;
	private ButtonGroup buttons;
	private ArrayList<String> options;
	
	/*
	 * Gera o label no início da fase.
	 */
	public void generatePhase(JPanel panel, ArrayList<String> lines){
		for(String l:lines){
			split = l.split(";");
			createLabel(panel, split[0]);
			break;
		}
	}
	
	/*
	 *  A ideia eh receber o arraylist das linhas e ir removendo as questoes e as fases
	 * do texto a medida que forem sendo respondidas. Essa funcao so verifica se estao corretas.
	 */
	protected void printLines(ArrayList<String> lines){
		for(String l:lines){
			System.out.println(l);
		}
	}
		
	/*
	 * 
	 */
	protected ArrayList<String> createAlternatives(ArrayList<String> lines){
		options = new ArrayList<String>();
		int count = 0, correctAnswerPosition;
		for(String l:lines){
			if(count == 0) { //Aqui a primeira linha contem  o cabecalho (Phase X: Descricao); 
				count++;
				continue;
			}
			else if(count == 1){
				split = l.split(";");
				for(int i = 1; i < 5; i++){
					options.add(split[i]);
				}
 
				lines.remove(1); //remove a segunda linha e deixa o cabecalho (Phase X: Descricao);

		        correctAnswer = l;
		        correctAnswerPosition = correctAnswer.lastIndexOf(";");
		        correctAnswer = correctAnswer.substring(correctAnswerPosition + 1);
			
				return options;
			
			}
		}
		return options;
	}
	
	/*
	 * Le as questoes do disco e insere nos botoes.
	 */
	public void createButtonGroup(JPanel panel, ArrayList<String> questions){
		ArrayList<String> alternatives = createAlternatives(questions);
		this.buttons = new ButtonGroup();
		JRadioButton option;
		createLabel(panel, alternatives.get(0));
		for(int i =1; i < 4; i++){
			option = createOptions(alternatives.get(i));
			buttons.add(option);
			panel.add(option);
		}
	}
	/*
	 * Cria o label no painel.
	 */
	public void createLabel(JPanel panel, String text){
		JLabel label = new JLabel(text);
		label.setHorizontalAlignment(CENTER);
		panel.add(label, BorderLayout.NORTH);
	}
	
	/*
	 * Monta as alternativas das questoes.
	 */
	protected JRadioButton createOptions(String text){
		JRadioButton button = new JRadioButton(text);
        button.setMnemonic(KeyEvent.VK_C);
        button.addActionListener(this);
        return button;
	}
	
	/*
	 * 
	 * Citar fonte corretamente.
	 */
	public String getSelected() {
        for (Enumeration<AbstractButton> auxButtons = this.buttons.getElements();auxButtons.hasMoreElements();) {
            AbstractButton button = auxButtons.nextElement();

            if (button.isSelected()) {
            	this.selected = (String)button.getText().substring(0, 2);
            	if(this.selected.equals(correctAnswer)){
            		return "correct";
            	}else{
            		return "wrong";
            	}
            }
        }
        return null;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
