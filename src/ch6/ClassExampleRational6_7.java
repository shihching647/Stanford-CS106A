package ch6;/*
 * File: Student.java
 * Purpose: Give a new class Student
 */

import acm.program.*;

public class ClassExampleRational6_7 extends ConsoleProgram{
	public void run() {
		//加法
		Rational num1 = new Rational(1, 2);
		Rational num2 = new Rational(1, 3);
		Rational num3 = new Rational(1, 6);
		Rational sum = num1.add(num2).add(num3);
		println(num1 + " + " + num2 + " + " + num3 + " = " + sum);
		//減法
		Rational difference = num1.subtract(num2).subtract(num3);
		println(num1 + " - " + num2 + " - " + num3 + " = " + difference);
		//乘法
		Rational product = num1.multiply(num2).multiply(num3);
		println(num1 + " * " + num2 + " * " + num3 + " = " + product);
		//除法
		Rational quotient = num1.divide(num2).divide(num3);
		println(num1 + " / " + num2 + " / " + num3 + " = " + quotient);
		
	}
	
	public class Rational{

		/**
		 * Create the new Rational with the value of x / y
		 * @param x The numerator of this Rational.
		 * @param y The denominator of this Rational.
		 */
		//先定義Constructor:
		//1.需化成最簡分數:先取分子分母的最大公因數g, 分子為  x / g,分母為 y / g.
		//2.分母永遠為正數:若分母為負數,分子加一個負號
		public Rational(int x, int y) {
			int g = gcd(Math.abs(x), Math.abs(y));
			num = x / g;
			den = Math.abs(y) / g;  //分母永遠為正
			if(y < 0) num = -num;
		}
		
		//Create the new Rational initialized to zero 
		public Rational() {
			this(0);
		}
		
		/**
		 * Create the new Rational from the integer argument
		 * @param n The initial value
		 */
		public Rational(int n) {
			this(n, 1);
		}
		//******************************************************
		/**
		 * Adds the rational number r to this one and returns the sum.
		 * @param r The rational number to be added
		 * @return The rational number of the sum
		 */
		public Rational add(Rational r) {
			return new Rational(this.num * r.den + this.den * r.num, this.den * r.den);
		}
		
		/**
		 * Subtract the rational number r from this one.
		 * @param r The rational number to be subtracted
		 * @return The result of substracting r from current number
		 */
		public Rational subtract(Rational r) {
			return new Rational(this.num * r.den - this.den * r.num, this.den * r.den);
		}
		/**
		 * Multiplying this number by the rational number r. 
		 * @param r The rational number used as a multiplier
		 * @return The result of the multiplying current number by r
		 */
		public Rational multiply(Rational r) {
			return new Rational(this.num * r.num, this.den * r.den);
		}
		/**
		 * Divides this number by the rational number r.
		 * @param r The rational number used as a divider
		 * @return The result of the dividing current number by r
		 */
		public Rational divide(Rational r) {
			return new Rational(this.num * r.den, this.den * r.num); 
		}
		
		//*********************************************************
		/**
		 * Creates a string representation of this rational number.
		 * @return The string representation of this rational number.
		 */
		public String toString() {
			if(den == 1) {
				return "" + num;
			}else {
				return num + "/" + den;
			}
		}
		//*********************************************************
		/**
		 * Calculate the gcd of m, n using Euclid's algorithm
		 * @param m	First integer
		 * @param n	Second integer
		 * @return The gcd of x, y
		 */
		private int gcd(int m, int n) {
			int r = m % n;
			while(r != 0) {
				m = n;
				n = r;
				r = m % n;
			}
			return n;
		}
		
		//instance variables
		private int num;  //The numerator of this Rational.
		private int den;  //The denominator of this Rational.
	}
}

