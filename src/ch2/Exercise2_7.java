package ch2;/*
 * File: OlympicLogo
 * Purpose: Draw a olympic logo
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Exercise2_7 extends GraphicsProgram{
	public void run() {
		//blue circle
		GOval c1 = new GOval(100, 30, 80 ,80);
		c1.setColor(Color.BLUE);
		add(c1);
		//black circle
		GOval c2 = new GOval(100, 30, 80 ,80);
		c2.setColor(Color.BLACK);
		c2.move(100, 0);
		add(c2);
		//red circle
		GOval c3 = new GOval(100, 30, 80 ,80);
		c3.setColor(Color.RED);
		c3.move(200, 0);
		add(c3);
		//yellow circle
		GOval c4 = new GOval(100, 30, 80 ,80);
		c4.setColor(Color.YELLOW);
		c4.move(50, 50);
		add(c4);
		//green circle
		GOval c5 = new GOval(100, 30, 80 ,80);
		c5.setColor(Color.GREEN);
		c5.move(150, 50);
		add(c5);
	}
}
