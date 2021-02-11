package ch2;/*
 * File: OlympicLogo3Pixel
 * Purpose: Draw a olympic logo with 3 pixel width
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Exercise2_8_hard extends GraphicsProgram{
	private static final int width = 3; //圓圈Width爲3pixel 
	public void run() {
		//blue circle, c1先填滿藍色,再用c1w白色部分的把藍色的遮住
		//c1w,c1之間原點差(width,width),直經差 2*wdith
		GOval c1 = new GOval(100, 30, 80 ,80);
		c1.setColor(Color.BLUE);
		c1.setFilled(true);
		add(c1);
		GOval c1w = new GOval(100, 30, 80 - 2 * width ,80 - 2 * width);
		c1w.move(width, width);
		c1w.setColor(Color.WHITE);
		c1w.setFilled(true);
		add(c1w);
		
		//black circle
		GOval c2 = new GOval(100, 30, 80 ,80);
		c2.setColor(Color.BLACK);
		c2.setFilled(true);
		c2.move(100, 0);
		add(c2);
		GOval c2w = new GOval(100, 30, 80 - 2 * width ,80 - 2 * width);
		c2w.setColor(Color.WHITE);
		c2w.setFilled(true);
		c2w.move(100, 0);
		c2w.move(width, width);
		add(c2w);
		
		//red circle
		GOval c3 = new GOval(100, 30, 80 ,80);
		c3.setColor(Color.RED);
		c3.move(200, 0);
		c3.setFilled(true);
		add(c3);
		GOval c3w = new GOval(100, 30, 80 - 2 * width ,80 - 2 * width);
		c3w.setColor(Color.WHITE);
		c3w.setFilled(true);
		c3w.move(200, 0);
		c3w.move(width, width);
		add(c3w);
		
		//yellow circle
		GOval c4 = new GOval(100, 30, 80 ,80);
		c4.setColor(Color.YELLOW);
		c4.move(50, 50);
		c4.setFilled(true);
		add(c4);
		GOval c4w = new GOval(100, 30, 80 - 2 * width ,80 - 2 * width);
		c4w.setColor(Color.WHITE);
		c4w.setFilled(true);
		c4w.move(50, 50);
		c4w.move(width, width);
		add(c4w);
		
		//green circle
		GOval c5 = new GOval(100, 30, 80 ,80);
		c5.setColor(Color.GREEN);
		c5.move(150, 50);
		c5.setFilled(true);
		add(c5);
		GOval c5w = new GOval(100, 30, 80 - 2 * width ,80 - 2 * width);
		c5w.setColor(Color.WHITE);
		c5w.setFilled(true);
		c5w.move(150, 50);
		c5w.move(width, width);
		add(c5w);
	}
}
