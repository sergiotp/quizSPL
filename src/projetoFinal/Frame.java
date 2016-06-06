package projetoFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	
	/*
	 * Frame principal do jogo.
	 */
	private Container painelDeConteudo;
	private ArrayList<Pontuacao> ranking;
	private JList<?> list;
	String dificuldade;

	public Frame() {
		Fowler.getInstance().setFowler(5);
		this.setSize(820, 360);
		this.setTitle("Bad Smells Game");
		
		/*
		 * Localizacao relativa a null, centraliza na tela. Conforme
		 * especificao da Oracle.
		 */
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Insercao do cabecalho.
		 */
		JMenuBar barraDeMenus = new JMenuBar();
		
		this.adicionarOpcoesMenu(barraDeMenus);

		this.setJMenuBar(barraDeMenus);
		
		this.setVisible(true);
		
		this.painelDeConteudo = getContentPane();
		this.painelDeConteudo.add(new ComoJogar(), BorderLayout.NORTH);
		JLabel label  = new JLabel();
		label.setText("Are you in ?");
		label.setFont(label.getFont().deriveFont(36.0f));
		label.setBorder(BorderFactory.createEmptyBorder(10,50,10,350));
		painelDeConteudo.add(label, BorderLayout.CENTER);
		this.painelDeConteudo.add(new PainelDeOpcoes(), BorderLayout.SOUTH);
	

	}

	protected void criarPainelDeConteudo(String dificuldade) {
		
		/*
		 * Container para as questoes.
		 */
		this.painelDeConteudo = getContentPane();
		this.painelDeConteudo.add(new PainelDePerguntas(), BorderLayout.CENTER);
		this.painelDeConteudo.add(new Label(), BorderLayout.SOUTH);
		Label.resetar();
		this.painelDeConteudo.revalidate();
		this.painelDeConteudo.repaint();
				
	}

	protected void destruirPainel() {
		if (this.painelDeConteudo == null) {
			return;
		}
		this.painelDeConteudo.removeAll();

	}

	protected void adicionarOpcoesMenu(JMenuBar barraDeMenus) {
		JMenu opcao1 = new JMenu("Arquivo");
		this.adicionarOpcoes(opcao1, "Novo jogo");
		//this.adicionarOpcoes(opcao1, "Ranking Normal");
		//this.adicionarOpcoes(opcao1, "Ranking Dificil");
		this.adicionarOpcoes(opcao1, "Sair");

		JMenu opcao2 = new JMenu("Ajuda");
		this.adicionarOpcoes(opcao2, "Como jogar");
		this.adicionarOpcoes(opcao2, "Sobre");

		barraDeMenus.add(opcao1);
		barraDeMenus.add(opcao2);
		barraDeMenus.setBackground(Color.GRAY);
	}

	protected void adicionarOpcoes(JMenu opcao, String texto) {
		JMenuItem item = new JMenuItem(texto);
		item.setActionCommand(texto);
		item.addActionListener(this);
		opcao.add(item);
	}

	protected void comoJogar() {
		String comoJogar = "This game has 5 phases \n"
				+ "For each phase: \n"
				+ " -Guess the bad smell.\n"
				+ " -Choose the right smell characteristic \n"
				+ " -Choose the appropriate refactoring for the smell \n"
				+ "You have 5 chances ('Fowlers') to miss answers \n"
				+ "To receive 5 more Fowlers, answer true or false \n";
		JOptionPane.showMessageDialog(this, comoJogar, "Como Jogar", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void sobre() {
		String sobre = "Trabalho feito para a disciplina "
				+ "Reutiliza��o de Software,\nda Universidade Federal de Minas Gerais.\n" + "Professor: Eduardo Figueiredo \n"
				+ "Alunos: Eduardo Fernandes, Larissa Macedo, \n" + "Leonardo Apolin�rio,S�rgio Henrique e Vinicius Cesar.";
		JOptionPane.showMessageDialog(this, sobre, "Sobre", JOptionPane.INFORMATION_MESSAGE);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
	
		switch (comando) {
		case "Novo jogo":
			this.destruirPainel();
			this.criarPainelDeConteudo(this.dificuldade);
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

}
