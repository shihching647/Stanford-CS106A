package ch12;

import acm.program.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ReverseFileUsingJFileChooser12_7 extends ConsoleProgram{
	
	public void run() {
		println("This program reverses the lines in a file.");
		BufferedReader rd = openFileReaderUsingChooser();
		if(rd != null) {
			String[] lines = readLineArray(rd);
			for(int i = lines.length - 1; i >= 0; i--) {
				println(lines[i]);
			}
		}
	}
	
	private String[] readLineArray(BufferedReader rd) {
		ArrayList<String> lineList = new ArrayList<String>();
		try {
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				lineList.add(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		String[] lines = new String[lineList.size()];
		for(int i = 0; i < lines.length; i++) {
			lines[i] = lineList.get(i);
		}
		return lines;
	}

	private BufferedReader openFileReaderUsingChooser() {
		BufferedReader rd = null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			try {
				File file = chooser.getSelectedFile();
				rd = new BufferedReader(new FileReader(file));
			} catch(IOException e) {
				println("Can't open that File.");
			}
		}
		return rd;
	}
}
