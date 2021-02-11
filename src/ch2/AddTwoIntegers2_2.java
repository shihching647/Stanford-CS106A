package ch2;/*
 * File: AddTwoIntegers.java
 * Purpose: 將兩個integers相加,並將結果顯示在console上
 */

import acm.program.*;

public class AddTwoIntegers2_2 extends ConsoleProgram{
	
	public void run() {
		println("This program is adding two integers.");
		int n1 = readInt("Enter n1:");
		int n2 = readInt("Enter n2:");
		int total = n1 + n2;
		println("The sum is " + total + ".");
	}
}

