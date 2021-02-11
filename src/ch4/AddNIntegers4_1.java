package ch4;/*
 * File: AddNIntegers
 * Purpose: This program adds N integers and show the result.
 * To change the number of integers, change the definition of N_VALUES. 
 */

import acm.program.*;

public class AddNIntegers4_1 extends ConsoleProgram{
	
	public void run(){
		println("This program adds " + N_VALUES + " integers.");
		int sum = 0;
		for(int i = 1; i <= N_VALUES; i++) {
			int val = readInt("Enter value" + i + ": ");
			sum += val;
		}
		
		println("The sum is " + sum + ".");

	}
	// The number of integers --> N_VALUES
	private static final int N_VALUES = 10;
	
}
