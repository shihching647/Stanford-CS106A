package ch8;/*
 * File:PigLatin
 * Purpose: This file takes a line of text and converts each word into Pig Latin.
 * The rules for forming Pig Latin words are as follows:
 * 1.If the word begins with a vowel, add "way" to the end of the word.
 * 2.If the word begins with a consonant, extract the set of consonants up
 *  to the first vowel, move that set of consonants to the end of the word
 *  and add "ay".
 */

import acm.program.*;
import java.util.*;

public class PigLatin_8_6_difficult extends ConsoleProgram{
	
	public void run() {
		
		println("This program translates a line into Pig Latin.");
		String line = readLine("Enter a line: ");
		println(translateLine(line));
		
	}
	
	/* Translate a line into Pig Latin.
	 * 1.用StringTokenizer把每一個word取出並轉成Pig Latin
	 * whlie(還有更多word) 翻譯每一個word
	 */
	private String translateLine(String line) {
		
		StringTokenizer tokenizer = new StringTokenizer(line, DELIMITERS, true); //把中間的標點符號也保留
		String result = "";
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if(isWord(token)) //要確認是否為文字
				token = translateWord(token);
			result += token;
		}
		
		return result;
		
	}
	
	//確認是否為一個word,看word裡面的每一個字母是否為letter,只要有一個不是就return false
	private boolean isWord(String word) {
		for(int i = 0; i < word.length(); i++) {
			if(!Character.isLetter(word.charAt(i))) //只要有一個不是就return false
				return false;
		}
		return true;
	}
	
	/* Translate a word into Pig Latin.
	 *     先找到母音的位置,可分成下列三種情況:
	 * 1.沒有母音-> word不動
	 * 2.母音在字首-> word + "way"
	 * 3.母音在中間-> 依母音位置分成前後兩段, return 後面 + 前面 + "ay"
	 */
	private String translateWord(String word) {
		int vp = findVowel(word);
		if(vp == -1) {
			return word;
		}else if(vp == 0) {
			return word + "-way";
		}else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp, word.length());
			return tail + "-" + head + "ay";
		}
	}
	
	//找母音位置,若沒有母音則回傳-1
	private int findVowel(String word) {
		int vp = -1;
		for(int i = 0; i < word.length(); i++) {
			if(isEnglishVowel(word.charAt(i)))
				return i;
		}
		return vp;
	}
	
	//檢查字母是否為母音
	private boolean isEnglishVowel(char ch) {
		switch(Character.toLowerCase(ch)) {
			case'a': case'e': case'i': case'o': case'u':
				return true;
			default:
				return false;
		}
	}
	
	//定義全部的標點符號
	private static final String DELIMITERS = "!@#$%^&*()_-=+{[}]:;\"'<,>.?/~`|\\ ";

}
