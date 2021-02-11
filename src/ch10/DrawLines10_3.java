package ch10;/*
 * File:DrawLines
 * Purpose:mousePressed和mouseDragged例子.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;


public class DrawLines10_3 extends GraphicsProgram{
	
	public void init() {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line);
	}
	
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(),e.getY());
	}
	
	private GLine line;

}
