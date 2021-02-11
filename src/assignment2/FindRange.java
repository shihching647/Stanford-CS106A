package assignment2;/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		int num, largest, smallest;
		println("This program finds the largest and smallest numbers.");
		num = readInt("? ");
		//第一次就輸入SENTINEL->No values have been entered!
		if(num == SENTINEL)
			println("No values have been entered!");
		else {
			largest = smallest = num; //第一次輸入的數字為largest and smallest
			while(true) {
				num = readInt("? ");
				if(num == SENTINEL)
				break;
				largest = Math.max(largest, num);
				smallest = Math.min(smallest, num);
			}
			println("Smallest: " + smallest);
			println("Largest: " + largest);
		}
	}
	
	private static final int SENTINEL = 0;
}

