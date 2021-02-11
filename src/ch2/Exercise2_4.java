package ch2;/*
 * File: DrawHouse
 * Purpose: Draw a house
 */

import acm.program.*;
import acm.graphics.*;


public class Exercise2_4 extends GraphicsProgram{
	public void run() {
		add(new GLine(30, 40, 130, 40));
		add(new GLine(30, 40, 80, 20));
		add(new GLine(80, 20, 130, 40));
		add(new GRect(30, 40, 100, 50));
		add(new GRect(40, 50, 15, 15));
		add(new GRect(105, 50, 15, 15));
		add(new GRect(70, 50, 20, 40));
		add(new GOval(83, 67, 3,3));
	}
}
