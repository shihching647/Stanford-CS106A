package ch9;/*
 * File:StopSign
 * Purpose:創造一個Stop sign
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class StopSign9_15 extends GraphicsProgram{
	
	public void run() {
		
		//畫Stop sign
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		GPolygon signEdge = createOctagon(EDGE_LENGTH + 5);
		signEdge.setFilled(true);
		signEdge.setFillColor(Color.WHITE);
		add(signEdge, cx, cy);
		GPolygon sign = createOctagon(EDGE_LENGTH);
		sign.setFilled(true);
		sign.setFillColor(Color.RED);
		add(sign, cx, cy);
		//寫文字Stop
		GLabel stop = new GLabel("STOP");
		stop.setFont("SansSerif-bold-96");
		stop.setColor(Color.WHITE);
		add(stop, cx - stop.getWidth() / 2, cy + stop.getAscent() / 2 - SHIFT);
		
		
	}
	
	//自己寫的
	private GPolygon createOctagon(double side) {
		
		GPolygon octagon = new GPolygon();
		octagon.addVertex((-side / 2) / GMath.tanDegrees(22.5),-side / 2);  //這邊是用GMath.tanDegrees()
		int angle = 45;
		for(int i = 0; i < 8; i++) {
			octagon.addPolarEdge(side, angle);
			angle -= 45;
		}
		return octagon;
		
	}
	
	//課本方法
	private GPolygon createOctagon1(double side) {
		
		GPolygon octagon = new GPolygon();
		octagon.addVertex(-side / 2, side / 2 + side / Math.sqrt(2));
		int angle = 0;
		for(int i = 0; i < 8; i++) {
			octagon.addPolarEdge(side, angle);
			angle += 45;
		}
		return octagon;
		
	}
	
	private static final double EDGE_LENGTH = 150;
	private static final double SHIFT = 15; //因為GLabel上面會留一點空白,所以要把STOP文字往上移一個量 
}
