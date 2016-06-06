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
	private Container contentPanel;
	private PanelFactory panelFactory = new PanelFactory();

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
		JMenuBar menuBar = new JMenuBar();
		
		this.addOptionsToMenu(menuBar);
		this.setJMenuBar(menuBar);		
		this.setVisible(true);
		
		this.contentPanel = getContentPane();
		this.contentPanel.add(new GameInfo(), BorderLayout.NORTH);
		JLabel label  = new JLabel();
		label.setText("Are you in ?");
		label.setFont(label.getFont().deriveFont(36.0f));
		label.setBorder(BorderFactory.createEmptyBorder(10,50,10,350));
		contentPanel.add(label, BorderLayout.CENTER);
		this.contentPanel.add(panelFactory.getPanel("OPTIONS").draw(), BorderLayout.SOUTH);
	

	}

	protected void createContentPanel() {		
		/*
		 * Container para as questoes.
		 */
		this.contentPanel = getContentPane();
		this.contentPanel.add(panelFactory.getPanel("QUESTIONS").draw(), BorderLayout.CENTER);
		this.contentPanel.add(new Label(), BorderLayout.SOUTH);
		Label.reset();
		this.contentPanel.revalidate();
		this.contentPanel.repaint();				
	}

	protected void destroyPanel() {
		if (this.contentPanel == null) {
			return;
		}
		this.contentPanel.removeAll();
	}

	protected void addOptionsToMenu(JMenuBar menuBar) {
		JMenu optionOne = new JMenu("Arquivo");
		this.addOptions(optionOne, "Novo jogo");
		//this.adicionarOpcoes(opcao1, "Ranking Normal");
		//this.adicionarOpcoes(opcao1, "Ranking Dificil");
		this.addOptions(optionOne, "Sair");

		JMenu optionTwo = new JMenu("Ajuda");
		this.addOptions(optionTwo, "Como jogar");
		this.addOptions(optionTwo, "Sobre");

		menuBar.add(optionOne);
		menuBar.add(optionTwo);
		menuBar.setBackground(Color.GRAY);
	}

	protected void addOptions(JMenu option, String text) {
		JMenuItem item = new JMenuItem(text);
		item.setActionCommand(text);
		item.addActionListener(this);
		option.add(item);
	}

	protected void howToPlay() {
		JOptionPane.showMessageDialog(this, GameInfo.getTextInfo(), "Como Jogar", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void showAbout() {
		JOptionPane.showMessageDialog(this, GameInfo.getAboutInfo(), "Sobre", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	
		switch (command) {
		case "Novo jogo":
			this.destroyPanel();
			//this.criarPainelDeConteudo(this.dificuldade);
			break;
		case "Como jogar":
			this.howToPlay();
			break;
		case "Sobre":
			this.showAbout();
			break;
		case "Sair":
			System.exit(0);
		}
	}
}
