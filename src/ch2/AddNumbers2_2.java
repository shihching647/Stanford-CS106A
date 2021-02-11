package ch2;/*
 * File: AddTwoNumbers.java
 * Purpose: 將兩個numbers相加,並將結果顯示在dialog上
 */

import acm.program.*;

public class AddNumbers2_2 extends DialogProgram{
	
	public void run() {
		println("This program is adding two numbers.");
		double n1 = readDouble("Enter n1:");
		double n2 = readDouble("Enter n2:");
		double total = n1 + n2;
		println("The sum is " + total + ".");
	}
}

