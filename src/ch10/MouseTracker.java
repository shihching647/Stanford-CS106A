package ch10;/*
 * File:MouseTracker
 * Purpose:移動滑鼠,可將滑鼠的所在位置顯示出來
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;


public class MouseTracker extends GraphicsProgram{
	
	public void init() {
		traker = new GLabel("", 200,300);
		traker.setFont("Dialog-bold-24");
		add(traker);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e) {
		traker.setLabel("Mouse: " + e.getX() + ", " + e.getY());
	}
	
	
	private GLabel traker;

}