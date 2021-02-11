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

public class Target extends GraphicsProgram {	
	public void run() {
		//法一：先定義createCircle,再畫三個圓(中心都在xc,yc)
		//outer circle
		double xc = getWidth() / 2;
		double yc = getHeight() / 2;
		GOval c1 = createCircle(xc, yc, ONE_INCH);
		c1.setColor(Color.RED);
		c1.setFilled(true);
		add(c1);
		
		//middle circle
		GOval c2 = createCircle(xc, yc, 0.65 * ONE_INCH);
		c2.setColor(Color.WHITE);
		c2.setFilled(true);
		add(c2);
		
		//inner circle
		GOval c3 = createCircle(xc, yc, 0.3 * ONE_INCH);
		c3.setColor(Color.RED);
		c3.setFilled(true);
		add(c3);
		
	}
	
	/**
	 * 產生一個中心在(x, y)半徑為r的圓
	 * @param x 圓心x座標
	 * @param y 圓心y座標
	 * @param r 元的半徑
	 * @return 中心在(x, y)半徑為r的圓
	 */
	public GOval createCircle(double x, double y, double r) {
		GOval c = new GOval(x-r, y-r, 2 * r, 2 * r);
		return c;
	}
	
	private static final double ONE_INCH = 72;
}
