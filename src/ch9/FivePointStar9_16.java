package ch9;/*
 * File:FivePointStar
 * Purpose:畫一個五角星星
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class FivePointStar9_16 extends GraphicsProgram{
	
	public void run() {
		GPolygon star = createFivePointStar(STAR_WIDTH);
		star.setFilled(true);
		star.setFillColor(Color.YELLOW);
		add(star, getWidth() / 2, getHeight() / 2);
		
	}
	
	/**
	 * 用星星得寬度當參數,回傳一個五星圖☆
	 * 先定義3個重要量依序是:1.dx 2.dy 3.edge (page.326)
	 * @param width 星星的寬度
	 * @return 寬度為width的五星圖
	 */
	private GPolygon createFivePointStar(double width) {
		GPolygon star = new GPolygon();
		//以最左邊的那個角當作第一個頂點
		double dx = width / 2;  //為星星長度的一半
		double dy = dx * GMath.tanDegrees(18);  
		double edge = dx - dy * GMath.tanDegrees(36);
		star.addVertex(-dx, -dy);
		int angle = 0;
		for(int i = 1; i <= 5; i++) {
			star.addPolarEdge(edge, angle);
			star.addPolarEdge(edge, angle + 72);
			angle -= 72;
		}
		return star;
	}	
	
	private static final double STAR_WIDTH = 300;

}
