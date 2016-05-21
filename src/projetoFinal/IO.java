package projetoFinal;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class IO extends JLabel{
	
	String [] split;

	/*
	 * Lê as questões do disco.	
	 */
	protected static ArrayList<String> lerArquivo(){
		ArrayList<String> linhas = new ArrayList<String>();
		String linha;
		Scanner in = null;
		String arquivo = "questions/questions.txt";
		try {
			in = new Scanner(new FileReader(arquivo));
			while (in.hasNextLine()) {
				linha = in.nextLine();
				linhas.add(linha);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			in.close();
		}
		return linhas;
	}
	
	
}

