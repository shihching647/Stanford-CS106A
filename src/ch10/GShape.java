package ch10;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class GShape extends GPolygon{

	/**
	 * 產生一個寬為width, 高為height的菱形(reference在菱形正中間)
	 * @param width 菱形的寬
	 * @param height 菱形的高
	 * @return 資料型態為GPolygon的菱形
	 */
	public static GPolygon GDiamond(double width, double height) {
		GPolygon diamond = new GPolygon();
		diamond.addVertex(- width / 2, 0);
		diamond.addVertex(0, - height / 2);
		diamond.addVertex( width / 2, 0);
		diamond.addVertex(0, height / 2);
		return diamond;
	}
	/**
	 * 產生一個編長為side的正六邊形
	 * @param side 正六邊形的邊長
	 * @return 料型態為GPolygon,邊長為side的正六邊形
	 */
	public static GPolygon GHexagon(double side) {
		GPolygon hexagon = new GPolygon();
		hexagon.addVertex(-side, 0);
		for(int i = 0; i <= 5; i++) {
			hexagon.addPolarEdge(side, 60 - 60 * i);
		}
		return hexagon;

	}
	/**
	 * 產生一個寬為width的星星
	 * @param side 星星的寬度
	 * @return 資料型態為GPolygon,寬為width的星星
	 */
	public static GPolygon GStar(double width) {
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

}
