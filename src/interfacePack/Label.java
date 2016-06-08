package interfacePack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import businessPack.Fowler;

@SuppressWarnings("serial")
public class Label extends JPanel{
	
	private static int numberOfPlay = 0, hits = 0;
	private static JLabel label;
	
	public Label() {
		label = new JLabel("Remaining fowlers: " + Fowler.getInstance().getFowler());
		label.setForeground(Color.WHITE);
		
		this.add(label);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(getWidth(),30));
	}

	static protected void update(int jogadas, int acertos){
		label.setText("Remaining fowlers: " + Fowler.getInstance().getFowler());
	}
	
	static public void updateFowler(){
		label.setText("Remaining fowlers: " + Fowler.getInstance().getFowler());
	}
	
	static public void reset(){
		numberOfPlay = 0;
		hits = 0;
	}	
}
