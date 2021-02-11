package ch9;/*
 * File:GLabelExample
 * Purpose:創造一個Glabel,並放在螢幕的中間
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class GPolygonExample extends GraphicsProgram{
	
	public void run() {
		//菱形
		//reference在菱形正中央
		double w = 50;
		double h = 1.5 * w;
		GPolygon diamond1 = diamnodCreator(w, h);
		diamond1.setFilled(true);
		diamond1.setFillColor(Color.GREEN);
		add(diamond1, getWidth() / 4, getHeight() / 4);
		
		//正六邊形
//		GPolygon 
		double side = 50;
		GPolygon hexagon = hexagonCreator(side);
		add(hexagon, getWidth() / 4 * 3, getHeight() / 4);
		hexagon.setFilled(true);
		hexagon.setFillColor(Color.ORANGE);
		
		
	}
	
	/**
	 * 產生一個寬為width, 高為height的菱形(reference在菱形正中間)
	 * @param width 菱形的寬
	 * @param height 菱形的高
	 * @return 資料型態為GPolygon的菱形
	 */
	public GPolygon diamnodCreator(double width, double height) {
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
	public GPolygon hexagonCreator(double side) {
		GPolygon hexagon = new GPolygon();
		hexagon.addVertex(-side, 0);
		for(int i = 0; i <= 5; i++) {
			hexagon.addPolarEdge(side, 60 - 60 * i);
		}
		return hexagon;

	}

}
