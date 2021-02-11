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
import java.util.*;

public class Hangman extends ConsoleProgram {
	
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 1200;
	public static final int APPLICATION_HEIGHT = 750;

    public void run() {
    	
    	while(true) {
			initGame();
			while(!isOver()) {
				displayGuess();
				guess();
			}
			printResult();
			if(!isPlayAgain()) break;
    	}
    	println("************************************************\n End of the game!!");
	}
    
    //加入HangmanCanvas
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
    
	/*初始化遊戲:
	 * 1.初始化答案 answer
	 * 2.猜的次數 numOfGuess
	 * 3.猜的字 guess
	 * 4.畫布
	 */
    private void initGame() {
		println("Welcome to Hangman!");
		HangmanLexicon lex = new HangmanLexicon();
		println("Wordlist contains " + lex.getWordCount() + " words.");
		answer = lex.getWord((int)(Math.random() * lex.getWordCount()));  //(int)(Math.random() * 10)
		numOfGuess = 8;
		guess = new ArrayList<Character>();
		//reset canvas
		canvas.reset();
    }
    
    //遊戲是否結束
    private boolean isOver() {
    	return numOfGuess == 0 || isWin();
    }
    
    //顯示目前猜到的字word
    private void displayGuess() {
    	print("The word now loos like this: ");
    	String word = "";
    	for(int i = 0; i < answer.length(); i++) {
    		char ch = answer.charAt(i);
    		if(isInGuess(ch)) {
    			word += ch;
    		}else {
    			word += "-";
    		}
    	}
    	println(word);
    	//display on canvas
    	canvas.displayWord(word);
    }
    
    //檢查字母是否已經猜過
    private boolean isInGuess(char ch) {
    	for(int i = 0; i < guess.size(); i++) {
    		if(ch == guess.get(i))
    			return true;
    	}
    	return false;
    }
    
    //猜字
    private void guess() {
    	println("You have " + numOfGuess + " guesses left.");
    	String line = readLine("your guess: ");
    	//如果輸入的是空字串ch為空格, 不然就把第一個字轉成大寫
    	char ch = line.length() == 0 ? ' ':Character.toUpperCase(line.charAt(0));
    	/* 狀況:
    	 * 1. 輸入長度不為1 或 不是個字母-->Illegal input!!
    	 * 2.猜錯-->次數減一, 印出猜錯訊息, 更新canvas
    	 * 3.猜過一樣的答案-->沒做事
    	 * 4.猜對-->印出猜對訊息, 把字母加入guess裡面
    	 */
    	if(line.length() != 1 || !Character.isAlphabetic(ch)) {
    		println("Illegal input!!");
    	}
    	else if(!answer.contains(Character.toString(ch))){
    		numOfGuess--;
    		println("There are no " + Character.toString(ch) + "'s in the word.");
    		//更新canvas
    		canvas.noteIncorrectGuess(ch);
    	}
    	else if(isInGuess(ch));
    	else {
			println("That guess is correct.");
			guess.add(ch);
    	}
    }
    
    //檢查是否贏得遊戲
    private boolean isWin() {
    	for(int i = 0; i < answer.length(); i++) {
    		if(!isInGuess(answer.charAt(i)))
    				return false;
    	}
    	return true;
    }
    //印出結果
    private void printResult() {
    	if(isWin()) {
    		println("You guess the word: " + answer + "\nYou win");
    		canvas.displayWord(answer);
    	}else {
    		println("You're completely hung.\nThe word was: " + answer + "\nYou lose.");
    	}
    }
    //詢問是否再玩一次
    private boolean isPlayAgain() {
    	while(true) {
			String ans = readLine("Play again?(Y/N) ");
			ans = ans.toUpperCase();
			if(ans.equals("Y") || ans.equals("YES"))
				return true;
			else if(ans.equals("N") || ans.equals("NO"))
				return false;
    	}
    }

    //invas
    private String answer;  //用字串存answer
    private int numOfGuess; //剩餘的次數
    private ArrayList<Character> guess;  //用ArrayList存已猜過的字
    //HangmanCanvas
    private HangmanCanvas canvas;

}
