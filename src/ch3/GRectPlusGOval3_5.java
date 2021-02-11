package ch3;/*
 * File: GRectPlusGOval
 * Purpose: Give an example of GRect and GOval.(且位置落在視窗中間)
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class GRectPlusGOval3_5 extends GraphicsProgram{
	
	public void run(){
		//視窗的寬和高用getWidth(),getHeight()得到,扣掉圖形的寬和高在除2,即可得到圖型的座標(x,y)
		double x = (getWidth() - FIGURE_WIDTH) / 2;
		double y = (getHeight() - FIGURE_HEIGHT) / 2;
		// Create a rectangle
		GRect rect1 = new GRect(x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
		rect1.setFilled(true);
		rect1.setFillColor(Color.red);
		add(rect1);
		//Create a oval
		GOval oval1 = new GOval(x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
		oval1.setFilled(true);
		oval1.setFillColor(Color.green);
		add(oval1);
	}
	
	private static final double FIGURE_WIDTH = 300;
	private static final double FIGURE_HEIGHT = 250;

}
