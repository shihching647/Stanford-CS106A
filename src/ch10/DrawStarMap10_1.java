package ch10;/*
 * File:DrawStarMap
 * Purpose:mouseCilcked例子.Click mouse產生一顆星星
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*; //addMouseListeners()要import addMouseListeners()


public class DrawStarMap10_1 extends GraphicsProgram{
	
	public void init() {
		addMouseListeners();
	}
	
	public void mouseCilcked(MouseEvent e) {
		GStar star = new GStar(STAR_SIZE);
		star.setFilled(true);
		star.setFillColor(Color.YELLOW);
		add(star, e.getX(), e.getY());
		
	}
	
	private static final double STAR_SIZE = 20;

}
