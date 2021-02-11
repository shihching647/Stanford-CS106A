package ch8;/*
 * File: CharacterTest
 * Purpose: Test of the Character class.
 */

import acm.program.*;

public class CharacterTest extends ConsoleProgram{
	
	public void run() {
		
		char ch = 'E';
		println(ch + "->" + convertToUpperCase(ch) + " " 
				+ (isEnglishVowel(ch) ? " is a vowel." : " is not a vowel"));
		println(ch + "->" + Character.toUpperCase(ch) + " "
				+ (isEnglishVowel(ch) ? " is a vowel." : " is not a vowel"));
		
		
	}
	
	//練習題:重英文小寫變大寫
	private char convertToUpperCase(char ch) {
		//確認是小寫字母
		if(ch >= 'a' && ch <= 'z')
			return (char)('A' + ch - 'a');
		else
			return ch;  //若不是小寫,回傳原來的值
	}
	
	private boolean isEnglishVowel(char ch) {
		switch(Character.toLowerCase(ch)) {
			case'a': case'e': case'i': case'o': case'u':
				return true;
			default:
				return false;
		}
	}
	
}

