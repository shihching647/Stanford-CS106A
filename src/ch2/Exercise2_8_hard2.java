package ch2;/*
 * File: OlympicLogo3Pixel
 * Purpose: Draw a olympic logo with 3 pixel width
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Exercise2_8_hard2 extends GraphicsProgram{
	public void run() {
		//blue circle 用三個width = 1pixel的線疊再一起
		GOval c1 = new GOval(100, 30, 80 ,80);
		c1.setColor(Color.BLUE);
		add(c1);
		GOval c1_1 = new GOval(100 + 1, 30 + 1, 80 - 1.5 ,80 - 1.5);
		c1_1.setColor(Color.BLUE);
		add(c1_1);
		GOval c1_2 = new GOval(100 + 2, 30 + 2, 80 - 3, 80 - 3);
		c1_2.setColor(Color.BLUE);
		add(c1_2);
		
		//black circle
		GOval c2 = new GOval(100, 30, 80 ,80);
		c2.setColor(Color.BLACK);
		c2.move(100, 0);
		add(c2);
		GOval c2_1 = new GOval(100 + 1, 30 + 1, 80 - 1.5 ,80 - 1.5);
		c2_1.setColor(Color.BLACK);
		c2_1.move(100, 0);
		add(c2_1);
		GOval c2_2 = new GOval(100 + 2, 30 + 2, 80 - 3, 80 - 3);
		c2_2.setColor(Color.BLACK);
		c2_2.move(100, 0);
		add(c2_2);
		
		//red circle
		GOval c3 = new GOval(100, 30, 80 ,80);
		c3.setColor(Color.RED);
		c3.move(200, 0);
		add(c3);
		GOval c3_1 = new GOval(100 + 1, 30 + 1, 80 - 1.5 ,80 - 1.5);
		c3_1.setColor(Color.RED);
		c3_1.move(200, 0);
		add(c3_1);
		GOval c3_2 = new GOval(100 + 2, 30 + 2, 80 - 3, 80 - 3);
		c3_2.setColor(Color.RED);
		c3_2.move(200, 0);
		add(c3_2);

		//yellow circle
		GOval c4 = new GOval(100, 30, 80 ,80);
		c4.setColor(Color.YELLOW);
		c4.move(50, 50);
		add(c4);
		GOval c4_1 = new GOval(100 + 1, 30 + 1, 80 - 1.5 ,80 - 1.5);
		c4_1.setColor(Color.YELLOW);
		c4_1.move(50, 50);
		add(c4_1);
		GOval c4_2 = new GOval(100 + 2, 30 + 2, 80 - 3, 80 - 3);
		c4_2.setColor(Color.YELLOW);
		c4_2.move(50, 50);
		add(c4_2);
		
		//green circle
		GOval c5 = new GOval(100, 30, 80 ,80);
		c5.setColor(Color.GREEN);
		c5.move(150, 50);
		add(c5);
		GOval c5_1 = new GOval(100 + 1, 30 + 1, 80 - 1.5 ,80 - 1.5);
		c5_1.setColor(Color.GREEN);
		c5_1.move(150, 50);
		add(c5_1);
		GOval c5_2 = new GOval(100 + 2, 30 + 2, 80 - 3, 80 - 3);
		c5_2.setColor(Color.GREEN);
		c5_2.move(150, 50);
		add(c5_2);
	}
}
