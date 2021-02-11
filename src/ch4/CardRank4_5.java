package ch4;/*
 * File: CardRank
 * Purpose: 讓使用者輸入1~13,顯示相對應的樸克牌點數
 */

import acm.program.*;

public class CardRank4_5 extends ConsoleProgram{
	
	public void run(){
		
		println("This program converts integers to card rank.");
		int point = readInt("Enter an integer between 1 and 13: ");
		switch(point) {
			case 1: println("Ace"); break;
			case 11: println("Jack"); break;
			case 12: println("Queen"); break;
			case 13: println("King"); break;
			default: println(point); break;
		}
		
	}
	
}
