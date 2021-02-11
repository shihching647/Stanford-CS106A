package ch3;/*
 * File: CentimetersToFeetAndInches
 * Purpose: Centimeters to feet,inches( 1 inch = 2.54cm, 12 inches = 1 foot)
 */

import acm.program.*;

public class CentimetersToFeetAndInches3_4 extends ConsoleProgram{
	
	public void run(){
		println("This program converts centimeters to feet and inches.");
		double cm = readDouble("Enter values in cm :");
		//先把cm轉成totalInches, 再把totalInches轉成feet + inches
		double totalInches = cm / CM_PER_INCH;
		int feet = (int)(totalInches / INCHES_PER_FOOT);
		double inches = totalInches - feet * INCHES_PER_FOOT; //totalInches減掉feet的
		//最後結果
		println( cm + "cm = " + feet + "ft" + inches + "in");
	}
	
	private static final double CM_PER_INCH = 2.54;
	private static final int INCHES_PER_FOOT = 12;
}
