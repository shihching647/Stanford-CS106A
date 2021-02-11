package ch10;/*
 * File:FivePointStar
 * Purpose:畫一個五角星星
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
	

public class GStar extends GPolygon {
		
	public GStar(double width) {
		//以最左邊的那個角當作第一個頂點
		double dx = width / 2;  //為星星長度的一半
		double dy = dx * GMath.tanDegrees(18);  
		double edge = dx - dy * GMath.tanDegrees(36);
		addVertex(-dx, -dy);
		int angle = 0;
		for(int i = 1; i <= 5; i++) {
			addPolarEdge(edge, angle);
			addPolarEdge(edge, angle + 72);
			angle -= 72;
		}
	}
}	
	


