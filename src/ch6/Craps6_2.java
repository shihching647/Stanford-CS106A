package ch6;/*
 * File: Craps
 * Purpose: Craps game.
 * 有兩個骰子,第一次先擲兩顆骰子:
 * (1)2,3,12點 -> craps 輸了！
 * (2)7,11 -> natural 贏了！
 * (3)4,5,6,8,9,10 -> 進行第二回合: 第一次擲到的點數爲point，在擲到7之前擲到point爲贏！否則為輸！
 */

import acm.program.*;
import acm.util.*; //要用RandomGenerator必須import acm.util.*

public class Craps6_2 extends ConsoleProgram{
	
	public void run(){
		println("This is a Craps game.");
		//第一回合
		int point1 = rollTwoDice();
		if(point1 == 7 || point1 == 11) {
			println("That's a natural.  You win");
		}else if(point1 == 2 || point1 == 3 ||point1 == 12) {
			println("That's craps.  You lose");
		}else {
			//進入第二回合
			println("Your point is " + point1);
			while(true) {
				int point2 = rollTwoDice();
				if(point2 == point1) {
					println("You made your point.  You win.");
					break;
				}
				if(point2 == 7) {
					println("That's a 7.  You lose.");
					break;
				}
			}
		}
	}
	
	private int rollTwoDice() {
		int num1 = rgen.nextInt(1,6);
		int num2 = rgen.nextInt(1,6);
		int total = num1 + num2;
		println("Rolling dice: " + num1 + " + " + num2 + " = " + total);
		return total;
	}
	
	//要產生亂數必須要宣告RnadomGenerator的instance
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
