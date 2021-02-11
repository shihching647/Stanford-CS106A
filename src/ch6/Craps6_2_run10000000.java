package ch6;/*
 * File: Craps
 * Purpose: Craps game.
 * 有兩個骰子,第一次先擲兩顆骰子:
 * (1)2,3,12點 -> craps 輸了！
 * (2)7,11 -> natural 贏了！
 * (3)4,5,6,8,9,10 -> 進行第二回合: 第一次擲到的點數爲point，在擲到7之前擲到point爲贏！否則為輸！
 * **********************************************************************************
 * run一千萬次 --> 贏的機率~0.492
 */

import acm.program.*;
import acm.util.*; //要用RandomGenerator必須import acm.util.*

public class Craps6_2_run10000000 extends ConsoleProgram{
	
	public void run(){
		for(int j = 1; j <= 10; j++) {
			println("第" + j + "次模擬:");
			int win = 0, lose = 0;
			for(int i = 1; i <= TOTAL; i++) {
				if(runCraps()) win++;
				else lose++;
			}
			println("贏的機率: " + win + "/" + TOTAL);
			println("輸的機率: " + lose + "/" + TOTAL);
	}
}
	
	
	//Return a boolean: true為贏, false為輸
	private boolean runCraps(){
		//println("This is a Craps game.");
		//第一回合
		int point1 = rollTwoDice();
		if(point1 == 7 || point1 == 11) {
			return true;
		}else if(point1 == 2 || point1 == 3 ||point1 == 12) {
			return false;
		}else {
			//進入第二回合
			//println("Your point is " + point1);
			while(true) {
				int point2 = rollTwoDice();
				if(point2 == point1) {
					return true;
				}
				if(point2 == 7) {
					//println("That's a 7.  You lose.");
					return false;
				}
			}
		}
	}
	
	private int rollTwoDice() {
		int num1 = rgen.nextInt(1,6);
		int num2 = rgen.nextInt(1,6);
		int total = num1 + num2;
		//println("Rolling dice: " + num1 + " + " + num2 + " = " + total);
		return total;
	}
	
	//要產生亂數必須要宣告RnadomGenerator的instance
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int TOTAL = 10000000;

}
