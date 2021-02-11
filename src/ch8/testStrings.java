package ch8;

import acm.program.*;

public class testStrings extends ConsoleProgram{
	
	public void run() {
		println(isPalindrome("mom"));
		println(reverseString("Hello world!"));
		println(isPalindrome2("mom"));
	}
	
	private boolean isPalindrome(String str) {
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		}
		return true;
	}
	
	private String reverseString(String str) {
		String result = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	}
	
	private boolean isPalindrome2(String str) {
		return (str.equals(reverseString(str)));
	}

}
