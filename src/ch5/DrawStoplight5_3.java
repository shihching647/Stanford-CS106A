package ch5;/*
 * File: DrawStoplight
 * Purpose: This program draw a stoplight with a red, yellow, green light
 * in a gray rectangular frame.
 * Method: 用creatFilledCircle(double x, double y, double r, Color color)
 * 其中(x,y)是圓心, r是半徑, color是顏色
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawStoplight5_3 extends GraphicsProgram{
	
	public void run(){
		//畫灰色的frame
		//1.定義座標
		double fx = (getWidth() - FRAME_WIDTH) / 2;
		double fy = (getHeight() - FRAME_HEIGHT) / 2;
		//2.畫圖和顏色
		GRect frame = new GRect(fx, fy, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setFilled(true);
		frame.setFillColor(Color.GRAY);
		add(frame);
		
		//畫燈
		//1.先定義中間黃燈的座標(cx,cy),在上下移動d得到紅燈和綠燈的座標
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		double d = FRAME_HEIGHT / 4 + LAMP_RADIUS / 2;
		//2.畫圖和顏色
		add(creatFilledCircle(cx, cy, LAMP_RADIUS, Color.YELLOW));
		add(creatFilledCircle(cx, cy + d, LAMP_RADIUS, Color.GREEN));
		add(creatFilledCircle(cx, cy - d, LAMP_RADIUS, Color.RED));
	}
	
	//Return GOval, (x,y)是圓心, r是半徑, color是顏色
	private GOval creatFilledCircle(double x, double y, double r, Color color) {
		GOval circle = new GOval(x - r, y - r, 2 * r, 2 * r); //要用(2 * r),兩倍半徑
		circle.setFilled(true);
		circle.setFillColor(color);
		return circle;
	}
	
	private static final double FRAME_WIDTH = 200;
	private static final double FRAME_HEIGHT = 400;
	private static final double LAMP_RADIUS = 50;
	
}
