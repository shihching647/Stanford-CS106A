package ch8;/*
 * File:StringTest
 * Purpose:熟悉String的操作
 */

import acm.program.*;

public class StringTest extends ConsoleProgram{
	
	public void run() {
		/**
		 * 比較String和Character轉大寫的方法
		 */
//		String str = "abcde";
//		char ch = 'a';
//		println(str + "->" + str.toUpperCase());  //String要用str.toUpperCase()
//		println(ch + "->" + Character.toUpperCase(ch));  //char要用Character.toUpperCase(ch)
		
		/**
		 * Concat String N copies
		 */
//		println(concatNCopies("ABCDE" , 5));
		
		/**
		 * 產生Acronym name.
		 */
		String str = "national basketball association";
		println(str + " = " + acronym(str));
		
	}
	
	/**
	 * Concat String N copies
	 * @param str The string is to be copied.
	 * @param N	 How many copies you want to concat.
	 * @return a String Concat N copies of original string.
	 */
	private String concatNCopies(String str, int N) {
		String result = "";
		for(int i = 1; i <= N; i++) {
			result += str;
		}
		return result;
	}
	
	/**
	 * Create an acronym of a string.
	 * @param str The string will be translated to acronym. 
	 * @return An acronym
	 */
	private String acronym(String str) {
		String result = str.substring(0,1); //先取第一個字母
		int index = str.indexOf(" ");  //index初始值先找到第一個空格位置
		while(index != -1) {
			result += str.substring(index + 1, index + 2); //取(index+1)位置的字母
			index = str.indexOf(" ", index + 1); //從(index + 1)位置後開始找下一個空格
		}
		return result.toUpperCase(); //轉換成大寫
	}
	

}
