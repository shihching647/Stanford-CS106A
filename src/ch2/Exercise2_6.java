package ch2;/*
 * File: ArcheryTarget
 * Purpose: Draw a archery target
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Exercise2_6 extends GraphicsProgram{
	public void run() {
		//outer circle
		GOval c1 = new GOval(100, 30, 150, 150);
		c1.setColor(Color.RED);
		c1.setFilled(true);
		add(c1);
		//middle circle
		GOval c2 = new GOval(125, 55, 100, 100);
		c2.setColor(Color.white);
		c2.setFilled(true);
		add(c2);
		//inner circle
		GOval c3 = new GOval(150, 80, 50, 50);
		c3.setColor(Color.RED);
		c3.setFilled(true);
		add(c3);
	}
}
