package ch9;/*
 * File:GLabelExample
 * Purpose:創造一個Glabel,並放在螢幕的中間
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class GLabelExample extends GraphicsProgram{
	
	public void run() {
		GLabel label = new GLabel("Hello world!");
		label.setFont("Dialog-bold-48");
		double x = (getWidth() - label.getWidth()) / 2;
		double y = (getHeight() - label.getAscent()) / 2;  //要用getAscent(),不能用getHeight()
		add(label, x, y);		
	}

}
