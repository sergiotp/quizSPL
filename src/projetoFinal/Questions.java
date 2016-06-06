package projetoFinal;

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
	protected void generatePhase(JPanel painel, ArrayList<String> linhas){
		for(String l:linhas){
			split = l.split(";");
			createLabel(painel, split[0]);
			break;
		}
	}
	
	/*
	 *  A ideia eh receber o arraylist das linhas e ir removendo as questoes e as fases
	 * do texto a medida que forem sendo respondidas. Essa funcao so verifica se estao corretas.
	 */
	protected void printLines(ArrayList<String> linhas){
		for(String l:linhas){
			System.out.println(l);
		}
	}
		
	/*
	 * 
	 */
	protected ArrayList<String> createAlternatives(ArrayList<String> linhas){
		options = new ArrayList<String>();
		int count = 0, posicaoRespostaCerta;
		for(String l:linhas){
			if(count == 0) { //Aqui a primeira linha contem  o cabecalho (Phase X: Descricao); 
				count++;
				continue;
			}
			else if(count == 1){
				split = l.split(";");
				for(int i = 1; i < 5; i++){
					options.add(split[i]);
				}
 
				linhas.remove(1); //remove a segunda linha e deixa o cabecalho (Phase X: Descricao);

		        correctAnswer = l;
		        posicaoRespostaCerta = correctAnswer.lastIndexOf(";");
		        correctAnswer = correctAnswer.substring(posicaoRespostaCerta + 1);
			
				return options;
			
			}
		}
		return options;
	}
	
	/*
	 * Le as questoes do disco e insere nos botoes.
	 */
	protected void createButtonGroup(JPanel painel2, ArrayList<String> questoes){
		ArrayList<String> alternativas = createAlternatives(questoes);
		this.buttons = new ButtonGroup();
		JRadioButton opcao;
		createLabel(painel2, alternativas.get(0));
		for(int i =1; i < 4; i++){
			opcao = createOptions(alternativas.get(i));
			buttons.add(opcao);
			painel2.add(opcao);
		}
	}
	/*
	 * Cria o label no painel.
	 */
	public void createLabel(JPanel painel, String texto){
		JLabel label = new JLabel(texto);
		label.setHorizontalAlignment(CENTER);
		painel.add(label, BorderLayout.NORTH);
	}
	
	/*
	 * Monta as alternativas das questoes.
	 */
	protected JRadioButton createOptions(String texto){
		JRadioButton button = new JRadioButton(texto);
        button.setMnemonic(KeyEvent.VK_C);
        button.addActionListener(this);
        return button;
	}
	
	/*
	 * 
	 * Citar fonte corretamente.
	 */
	public String getSelected() {
        for (Enumeration<AbstractButton> auxBotoes = this.buttons.getElements();auxBotoes.hasMoreElements();) {
            AbstractButton botao = auxBotoes.nextElement();

            if (botao.isSelected()) {
            	this.selected = (String)botao.getText().substring(0, 2);
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
