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

public class QuestionsPanel extends JPanel implements Panel, ActionListener {

	JPanel painel;
	int fases = 0, alternativas = 0;	
	ArrayList<String> opcoes;
	Questoes q;
	JButton button = new JButton("Next");	
	
	public QuestionsPanel() {
		this.setBackground(Color.LIGHT_GRAY);
		this.painel = new JPanel(new GridLayout(0, 1));
		this.opcoes = IO.lerArquivo();
		this.percorrerFases();
		painel.setBorder(BorderFactory.createEmptyBorder(50,50,70,50));
		button.addActionListener(this);
	}
	
	public void percorrerFases(){
		this.q = new Questoes();
		this.q.fase(this, opcoes);
		this.percorrerQuestoes();
	
	}

	public void percorrerQuestoes(){
		
		this.q.criarGrupoBotoes(painel, opcoes);
		add(painel, BorderLayout.SOUTH);
		painel.setPreferredSize(new Dimension(800, 200));
		//this.button.addActionListener(this);
		add(button);
	}

	
	@Override
	public JPanel draw() {
		return new QuestionsPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String mensagem = "Choose one of the three options below!";
		String resposta = this.q.getSelecionado();

		if(resposta == null){ //Nao selecionou a alternativa.
			JOptionPane.showMessageDialog(this, mensagem, "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			if(resposta == "correct"){
				JOptionPane.showMessageDialog(this, "Correct answer :)", "", JOptionPane.INFORMATION_MESSAGE);
				//Atualizar o numero de questoes corretas.
				
			}else{
				JOptionPane.showMessageDialog(this, "Almost there :(", "", JOptionPane.INFORMATION_MESSAGE);
				int fowlerValue;
				if (this.fases < 5){
					fowlerValue = Fowler.getInstance().getFowler() - 1;					
					//Fowler.fowlers = Fowler.fowlers - 1;
				}else{
					fowlerValue = Fowler.getInstance().getFowler() - 2;
					//Fowler.fowlers = Fowler.fowlers - 2;
				}
				Fowler.getInstance().setFowler(fowlerValue);
				Label.atualizarFowler();
				if (Fowler.getInstance().getFowler() == 0){
					JOptionPane.showMessageDialog(this, "Game Over", "", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				//Atualizar o numero de questoes incorretas.
			}
			System.out.println(this.fases);
			this.verificaQuestoes();
		}
	}
	protected void verificaQuestoes(){
		if(this.alternativas < 2){//Ainda há alternativas a serem respondidas nessa fase.
			this.alternativas++;
			this.clearPainel();
			this.percorrerQuestoes();
		}else if(this.fases < 5){
			this.opcoes.remove(0); //Remove o cabeçalho Phase X: Descrição
			this.clearPainel();
			this.clearAll();
			this.alternativas = 0;
			this.fases++;
			this.percorrerFases();
		}else{
			JOptionPane.showMessageDialog(this, "You won", "", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
		
	/*
	 * Limpa o painel 
	 */
	protected void clearPainel(){
		this.painel.removeAll();;
		this.painel.revalidate();
		this.painel.repaint();
	}
	
	protected void clearAll(){
		this.removeAll();
		this.revalidate();
		this.repaint();
	}

}
