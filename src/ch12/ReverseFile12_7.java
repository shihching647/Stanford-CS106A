package ch12;

import acm.program.*;
import java.io.*;
import java.util.*;

public class ReverseFile12_7 extends ConsoleProgram{
	
	public void run() {
		println("This program reverses the lines in a file.");
		BufferedReader rd = openFileReader("Enter input filename: ");
		String[] lines = readLineArray(rd);
		for(int i = lines.length - 1; i >= 0; i--) {
			println(lines[i]);
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

	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd = null;
		while(true) {
			try {
				String fileName = readLine(prompt);
				rd = new BufferedReader(new FileReader(fileName));
				break;
			} catch(IOException e) {
				println("Can't find the file!");
			}
		}
		return rd;
	}
}
