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

public class Questoes extends JLabel implements ActionListener {
	
	private String [] split;
	private String respostaCorreta, selecionada;
	private ButtonGroup botoes;
	ArrayList<String> opcoes;
	
	/*
	 * Gera o label no início da fase.
	 */
	protected void fase(JPanel painel, ArrayList<String> linhas){
		for(String l:linhas){
			split = l.split(";");
			criaLabel(painel, split[0]);
			break;
		}
	}
	/*
	 *  A ideia eh receber o arraylist das linhas e ir removendo as questoes e as fases
	 * do texto a medida que forem sendo respondidas. Essa funcao so verifica se estao corretas.
	 */
	protected void imprimeLinhas(ArrayList<String> linhas){
		for(String l:linhas){
			System.out.println(l);
		}
	}
		
	/*
	 * 
	 */
	protected ArrayList<String> montarAlternativas(ArrayList<String> linhas){
		opcoes = new ArrayList<String>();
		int count = 0, posicaoRespostaCerta;
		for(String l:linhas){
			if(count == 0) { //Aqui a primeira linha contem  o cabecalho (Phase X: Descricao); 
				count++;
				continue;
			}
			else if(count == 1){
				split = l.split(";");
				for(int i = 1; i < 5; i++){
					opcoes.add(split[i]);
				}

				linhas.remove(1); //remove a segunda linha e deixa o cabecalho (Phase X: Descricao);

		        respostaCorreta = l;
		        posicaoRespostaCerta = respostaCorreta.lastIndexOf(";");
		        respostaCorreta = respostaCorreta.substring(posicaoRespostaCerta + 1);
			
				return opcoes;
			
			}
		}
		return opcoes;
	}
	
	/*
	 * Le as questoes do disco e insere nos botoes.
	 */
	protected void criarGrupoBotoes(JPanel painel2, ArrayList<String> questoes){
		ArrayList<String> alternativas = montarAlternativas(questoes);
		this.botoes = new ButtonGroup();
		JRadioButton opcao;
		criaLabel(painel2, alternativas.get(0));
		for(int i =1; i < 4; i++){
			opcao = montarOpcao(alternativas.get(i));
			botoes.add(opcao);
			painel2.add(opcao);
		}
	}
	/*
	 * Cria o label no painel.
	 */
	public void criaLabel(JPanel painel, String texto){
		JLabel label = new JLabel(texto);
		label.setHorizontalAlignment(CENTER);
		painel.add(label, BorderLayout.NORTH);
	}
	
	/*
	 * Monta as alternativas das questoes.
	 */
	protected JRadioButton montarOpcao(String texto){
		JRadioButton button = new JRadioButton(texto);
        button.setMnemonic(KeyEvent.VK_C);
        button.addActionListener(this);
        return button;
	}
	
	/*
	 * 
	 * Citar fonte corretamente.
	 */
	public String getSelecionado() {
        for (Enumeration<AbstractButton> auxBotoes = this.botoes.getElements();auxBotoes.hasMoreElements();) {
            AbstractButton botao = auxBotoes.nextElement();

            if (botao.isSelected()) {
            	this.selecionada = (String)botao.getText().substring(0, 2);
            	if(this.selecionada.equals(respostaCorreta)){
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
