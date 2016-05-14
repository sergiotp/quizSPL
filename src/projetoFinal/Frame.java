package projetoFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener{
	/*
	 * Frame principal do jogo. 
	 */
	
	private Container painelDeConteudo;
	private ArrayList<Pontuacao> ranking;
	@SuppressWarnings("rawtypes")
	private JList list;
	String dificuldade;
	public Frame() {
		this.setSize(820,660);
		this.setTitle("Jogo da Memória");
		/*
		 * Localização relativa a null, centraliza na tela. Conforme especificação da Oracle.
		 */
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Inserção do cabeçalho.
		 */
		JMenuBar barraDeMenus = new JMenuBar();
		this.adicionarOpcoesMenu(barraDeMenus);
		
		this.setJMenuBar(barraDeMenus);
	
		this.setVisible(true);
		
	}
	
	protected void criarPainelDeConteudo(String dificuldade){
		/*
		 * Container para as cartas.
		 */
		this.painelDeConteudo = getContentPane();
		this.painelDeConteudo.add(new PainelDeImagem(dificuldade), BorderLayout.CENTER);
		this.painelDeConteudo.add(new Label(),BorderLayout.SOUTH);
		Label.resetar();
		this.painelDeConteudo.revalidate();
		this.painelDeConteudo.repaint();
		
		
	}
	
	protected void destruirPainel(){
		if(this.painelDeConteudo == null){
			return;
		}
		this.painelDeConteudo.removeAll();
		

	}
	
	protected void adicionarOpcoesMenu(JMenuBar barraDeMenus){
		JMenu opcao1 = new JMenu("Arquivo");
		this.adicionarOpcoes(opcao1, "Novo jogo");
		this.adicionarOpcoes(opcao1, "Ranking Normal");
		this.adicionarOpcoes(opcao1, "Ranking Dificil");
		this.adicionarOpcoes(opcao1, "Sair");
				
		JMenu opcao2 = new JMenu("Ajuda");
		this.adicionarOpcoes(opcao2, "Como jogar");
		this.adicionarOpcoes(opcao2, "Sobre");
				
		barraDeMenus.add(opcao1);
		barraDeMenus.add(opcao2);
		barraDeMenus.setBackground(Color.GRAY);
	}
	
	protected void adicionarOpcoes(JMenu opcao, String texto){
		JMenuItem item = new JMenuItem(texto);
		item.setActionCommand(texto);
		item.addActionListener(this);
		opcao.add(item);
	}
	
	protected void comoJogar(){
		String comoJogar = "Como jogar:\n"+
				"Basta clicar em uma carta que esta irá virar para cima.\n"+
				"Se as duas forem iguais, permanecerão para cima, caso contrário,\n"+
				"as duas cartas irão virar para baixo.\n"
				+ "O jogador vence quando conseguir virar todas as cartas para cima.";
		JOptionPane.showMessageDialog(this, comoJogar,"Como Jogar",JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void sobre(){
		String sobre = "Trabalho feito para a disciplina "+
				"Programação modular,\nda Universidade Federal de Minas Gerais.\n"+
				"Professor: Douglas Macharet \n"+
				"Alunos: Leonardo Apolinário, Pedro Henrique, Marina Werneck e Suelem Loiola.";
		JOptionPane.showMessageDialog(this, sobre,"Sobre",JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando){
			case "Novo jogo":
				this.dificuldade = this.escolherDificuldade();
				if(this.dificuldade == null)
					return;
				this.destruirPainel();
				this.criarPainelDeConteudo(this.dificuldade);
				break;
			case "Ranking Normal":
				this.mostrarRanking(8);
				break;
			case "Ranking Dificil":
				this.mostrarRanking(16);
				break;
			case "Como jogar":
				this.comoJogar();
				break;
			case "Sobre":
				this.sobre();
				break;
			case "Sair":
				System.exit(0);
		}
		
	}
	
	protected void mostrarRanking(int nivelDificuldade){
		Jogo.dificuldade(nivelDificuldade);
		ranking = Jogo.montarRanking();
		JOptionPane.showMessageDialog(this, "JOGADOR " + " JOGADAS\n" + 
		ranking.get(0).getNome() + " "+ ranking.get(0).getNumeroJogadas() + " \n" +
		ranking.get(1).getNome() + " "+ ranking.get(1).getNumeroJogadas() + " \n" +
		ranking.get(2).getNome() + " "+ ranking.get(2).getNumeroJogadas() + " \n" +
		ranking.get(3).getNome() + " "+ ranking.get(3).getNumeroJogadas() + " \n" +
		ranking.get(4).getNome() + " "+ ranking.get(4).getNumeroJogadas() + " \n" +
		" \n", "Ranking", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String escolherDificuldade(){
		this.list = new JList(new String[] {"Normal", "Difícil"});
		JOptionPane.showMessageDialog(
		  this, this.list, "Nível de Dificuldade", JOptionPane.PLAIN_MESSAGE);
		if(this.list.getSelectedValue() == null)
			return null;
		else
			return this.list.getSelectedValue().toString();
	}
	
}
