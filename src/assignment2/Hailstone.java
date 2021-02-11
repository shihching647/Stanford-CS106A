package assignment2;/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int counter = 0;
		int num = readInt("Enter a number: ");
		while(num != 1) {
			if(num % 2 == 0) {
				print(num + " is even, so I take half: ");
				num /= 2;
				println(num);
				counter++;
			}
			else {
				print(num + " is odd, so I make 3n + 1: ");
				num = 3 * num + 1;
				println(num);
				counter++;
			}
		}
		println("The procsee took " + counter + " to reach 1.");
	}
}

