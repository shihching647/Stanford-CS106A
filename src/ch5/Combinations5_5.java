package ch5;/*
 * File: Combinations
 * Purpose: 寫出一個function可以算出組合數C(n,k) = n! / (k! * (n-k)!)
 */

import acm.program.*;

public class Combinations5_5 extends ConsoleProgram{
	
	public void run(){
		println("This programa is calculate combination C(n,k).");
		int n = readInt("Enter n: ");
		int k = readInt("Enter k: ");
		println("C(" + n + "," + k + ") = " + combinations(n, k));
		
	}
	
	private int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n-k));
	}
	
	private int factorial(int n) {
		int result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
}
