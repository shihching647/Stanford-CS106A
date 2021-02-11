package ch2;/*
 * File: GRectPlusGOval
 * Purpose: Give an example of GRect and GOval. 
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class GRectPlusGOval2_6 extends GraphicsProgram{
	
	public void run(){
		// Create a rectangle
		GRect rect1 = new GRect(75, 100, 300, 250);
		rect1.setFilled(true);
		rect1.setFillColor(Color.red);
		add(rect1);
		//Create a oval
		GOval oval1 = new GOval(75, 100, 300 ,250);
		oval1.setFilled(true);
		oval1.setFillColor(Color.green);
		add(oval1);
	}
}
