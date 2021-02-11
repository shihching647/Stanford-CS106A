package assignment4;/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;
import java.util.*;
import acm.util.*;

public class HangmanLexicon {
	
	public HangmanLexicon() {
		wordList = new ArrayList<String>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader("src/assignment4/HangmanLexicon.txt"));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				wordList.add(line);
			}
			rd.close();
		}catch(IOException e) {
			throw new ErrorException("Error!!");
		}
	}
	

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	}
	
	private ArrayList<String> wordList;
	
}
