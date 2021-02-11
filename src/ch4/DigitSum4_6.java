package ch4;/*
 * File: DigitSum
 * Purpose: 使用者數入任一位數,把各個位數總和算出來
 */

import acm.program.*;

public class DigitSum4_6 extends ConsoleProgram{
	
	public void run(){
		
		println("This program caluates the sum of digits.");
		int sum = 0;
		int num = readInt("Enter an integer: ");
		// (num % 10) 把最後一位數拿出來, (num / 10) 把最後一位數移除
		while(num > 0){
			sum += num % 10;
			num /= 10;
		}
		println("The sum of digit is " + sum + ".");
	}
		
}
	
