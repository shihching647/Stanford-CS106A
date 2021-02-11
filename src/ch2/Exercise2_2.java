package ch2;/*
 * File: AreaOfTriangle
 * Purpose: Prompt user enter bottom and height and evaluate the area
 * of the triangle.
 */

import acm.program.*;

public class Exercise2_2 extends ConsoleProgram{
	public void run() {
		println("This program evaluate the area of the triangle.");
		double bottom = readDouble("Enter the bottom: ");
		double height = readDouble("Enter the height: ");
		double area = bottom * height / 2;
		println("The area is " + area + ".");
	}
}
