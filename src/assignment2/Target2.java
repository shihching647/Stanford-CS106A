package assignment2;/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target2 extends GraphicsProgram {	
	public void run() {
		//法二：直接畫三個圓,中心與大小都回隨著內外圓圈而變
		//outer circle
		double x1 = (getWidth() - 2 * ONE_INCH) / 2;
		double y1 = (getHeight() - 2 * ONE_INCH) / 2;
		GOval c1 = new GOval(x1, y1, 2 * ONE_INCH, 2 * ONE_INCH);
		c1.setColor(Color.RED);
		c1.setFilled(true);
		add(c1);
		
		//middle circle
		double x2 = (getWidth() - 2 * 0.65 * ONE_INCH) / 2;
		double y2 = (getHeight() - 2 * 0.65 * ONE_INCH) / 2;
		GOval c2 = new GOval(x2, y2, 2 * 0.65 * ONE_INCH, 2 * 0.65 * ONE_INCH);
		c2.setColor(Color.white);
		c2.setFilled(true);
		add(c2);
		
		//inner circle
		double x3 = (getWidth() - 2 * 0.3 * ONE_INCH) / 2;
		double y3 = (getHeight() - 2 * 0.3 * ONE_INCH) / 2;
		GOval c3 = new GOval(x3, y3, 2 * 0.3 * ONE_INCH, 2 * 0.3 * ONE_INCH);
		c3.setColor(Color.RED);
		c3.setFilled(true);
		add(c3);
	}
	
	private static final double ONE_INCH = 72;
}
