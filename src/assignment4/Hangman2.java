package assignment4;/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman2 extends ConsoleProgram {

    public void run() {
		initGame();
		while(!guess.equals(answer) && numOfGuess == 8) {
			println("The word now loos like this: " + guess);
			println("You have " + (8 - numOfGuess) + " guesses left.");
			String line = readLine("Your guess: ");
			
			if(guess[numOfGuess].contains(line))
				continue;
			else
				numOfGuess--;
			
			char guessChar = Character.toUpperCase(line.charAt(0));
			updateGuess(guessChar);
		}
		println("End!!!");
    }

    private void initGame() {
		println("Welcome to Hangman!");
		HangmanLexicon lex = new HangmanLexicon();
		answer = lex.getWord(Math.abs(rgn.nextInt()) % 10);
		
		for(int i = 0; i < answer.length(); i++) {
			guess[numOfGuess] += "-";
		}
    }
    
    private void updateGuess(char guessChar) {
    	guess[numOfGuess] = "";
    	for(int i = 0; i < answer.length(); i++) {
    		if(guessChar == answer.charAt(i)) {
    			guess[numOfGuess] += guessChar;
    		}else
    			guess[numOfGuess] += "_";
    	}
    }
    
    
    private RandomGenerator rgn = new RandomGenerator();
    private int numOfGuess = 0;
    private String answer;
    private String[] guess = new String [8];
}
