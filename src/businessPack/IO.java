package businessPack;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class IO {
		
	public static ArrayList<String> readFile(){
		ArrayList<String> lines = new ArrayList<String>();
		String line;
		Scanner in = null;
		String file = "questions/questions.txt";
		try {
			in = new Scanner(new FileReader(file));
			while (in.hasNextLine()) {
				line = in.nextLine();
				lines.add(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			in.close();
		}
		return lines;
	}
	
	
}

