package ch5;/*
 * File: GreatestCommonDivisor
 * Purpose: 用兩種方法算出最大公因數(gcd) 1.brute force method  2.Euclid's algorithm
 */

import acm.program.*;

public class GreatestCommonDivisor5_6 extends ConsoleProgram{
	
	public void run(){
		println("This programa is calculate gcd(m,n) by different method.");
		int m = readInt("Enter m: ");
		int n = readInt("Enter n: ");
		
		//1.brute force method
		long startTime1 = System.currentTimeMillis();
		print("gcd(" + m + "," + n + ") = " + gcdBruteForce(m,n) + " by btute force method");
		long endTime1 = System.currentTimeMillis();
		println("(spend time : " + (endTime1 - startTime1) + "ms)");
		
		//2.Euclid's algorithm
		long startTime2 = System.currentTimeMillis();
		print("gcd(" + m + "," + n + ") = " + gcdEuclid(m,n) + " by Euclid's method");
		long endTime2 = System.currentTimeMillis();
		println("(Spend time : " + (endTime2 - startTime2) + "ms)");
		
	}
	
	private int gcdBruteForce(int m, int n) {
		// gcd必定小於或等於比較小的那個數字
		int min = Math.min(m, n);
		int gcd = 1;
		for(int i = 1 ; i <= min; i++) {
			if( n % i == 0 && m % i ==0 )
				gcd = i;
		}
		return gcd;
	}
	
	private int gcdEuclid(int m, int n) {
		int r = m % n;
		while(r != 0) {
			m = n;
			n = r;
			r = m % n;
		}
		return n;
	}
	
}
