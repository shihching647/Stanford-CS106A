package ch2;/*
 * File: AddThreeIntegers
 * Purpose: Add three integers
 */

import acm.program.*;

public class Exercise2_3 extends ConsoleProgram{
	public void run() {
		println("This program add three integers.");
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int n3 = readInt("Enter n3: ");
		int sum = n1 + n2 + n3;
		println("Tne sum is " + sum + ".");
	}
}
