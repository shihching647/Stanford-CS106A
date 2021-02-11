package ch2;/*
 * File: GRectExample
 * Purpose: Give an example of GRect. 
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class GRectExample2_5 extends GraphicsProgram{
	
	public void run(){
		GRect rect1 = new GRect(75, 100, 250, 300);
		rect1.setColor(Color.red);
		rect1.setFilled(true);
		rect1.setFillColor(Color.blue);
		add(rect1);
	}
}
