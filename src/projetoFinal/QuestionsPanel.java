package projetoFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import businessPack.Fowler;
import businessPack.IO;
import businessPack.Questions;

public class QuestionsPanel extends JPanel implements Panel, ActionListener {

	private JPanel panel;
	private int phases = 0, alternatives = 0;	
	private ArrayList<String> options;
	private Questions q;
	private JButton button = new JButton("Next");	
	
	public QuestionsPanel() {
		this.setBackground(Color.LIGHT_GRAY);
		this.panel = new JPanel(new GridLayout(0, 1));
		this.options = IO.readFile();
		this.goThroughPhases();
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,70,50));
		button.addActionListener(this);
	}
	
	public void goThroughPhases(){
		this.q = new Questions();
		this.q.generatePhase(this, options);
		this.goThroughQuestions();
	
	}

	public void goThroughQuestions(){
		
		this.q.createButtonGroup(panel, options);
		add(panel, BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(800, 200));
		//this.button.addActionListener(this);
		add(button);
	}

	
	@Override
	public JPanel draw() {
		return new QuestionsPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = "Choose one of the three options below!";
		String answer = this.q.getSelected();

		if(answer == null){ //Nao selecionou a alternativa.
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			if(answer == "correct"){
				JOptionPane.showMessageDialog(this, "Correct answer :)", "", JOptionPane.INFORMATION_MESSAGE);
				//Atualizar o numero de questoes corretas.
				
			}else{
				JOptionPane.showMessageDialog(this, "Almost there :(", "", JOptionPane.INFORMATION_MESSAGE);
				int fowlerValue;
				if (this.phases < 5){
					fowlerValue = Fowler.getInstance().getFowler() - 1;					
					//Fowler.fowlers = Fowler.fowlers - 1;
				}else{
					fowlerValue = Fowler.getInstance().getFowler() - 2;
					//Fowler.fowlers = Fowler.fowlers - 2;
				}
				Fowler.getInstance().setFowler(fowlerValue);
				Label.updateFowler();
				if (Fowler.getInstance().getFowler() == 0){
					JOptionPane.showMessageDialog(this, "Game Over", "", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				//Atualizar o numero de questoes incorretas.
			}
			System.out.println(this.phases);
			this.verificaQuestoes();
		}
	}
	protected void verificaQuestoes(){
		if(this.alternatives < 2){//Ainda há alternativas a serem respondidas nessa fase.
			this.alternatives++;
			this.clearPainel();
			this.goThroughQuestions();
		}else if(this.phases < 5){
			this.options.remove(0); //Remove o cabeçalho Phase X: Descrição
			this.clearPainel();
			this.clearAll();
			this.alternatives = 0;
			this.phases++;
			this.goThroughPhases();
		}else{
			JOptionPane.showMessageDialog(this, "You won", "", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
		
	/*
	 * Limpa o painel 
	 */
	protected void clearPainel(){
		this.panel.removeAll();;
		this.panel.revalidate();
		this.panel.repaint();
	}
	
	protected void clearAll(){
		this.removeAll();
		this.revalidate();
		this.repaint();
	}

}
