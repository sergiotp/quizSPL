package interfacePack;

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

import businessPack.Fowler;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	
	private Container contentPanel;
	private PanelFactory panelFactory = new PanelFactory();

	public Frame() {
		Fowler.getInstance().setFowler(5);
		this.setSize(820, 360);
		this.setTitle("Bad Smells Game");
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		JMenu optionOne = new JMenu("File");
		this.addOptions(optionOne, "New Game");
		this.addOptions(optionOne, "Exit");

		JMenu optionTwo = new JMenu("Help");
		this.addOptions(optionTwo, "How to play");
		this.addOptions(optionTwo, "About");

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
		JOptionPane.showMessageDialog(this, GameInfo.getTextInfo(), "How to play", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void showAbout() {
		JOptionPane.showMessageDialog(this, GameInfo.getAboutInfo(), "About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	
		switch (command) {
		case "New Game":
			this.destroyPanel();			
			break;
		case "How to play":
			this.howToPlay();
			break;
		case "About":
			this.showAbout();
			break;
		case "Exit":
			System.exit(0);
		default:
			break;		
		}
	}
}
