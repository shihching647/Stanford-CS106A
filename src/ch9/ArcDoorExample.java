package ch9;/*
 * File:StopSign
 * Purpose:創造一個Stop sign
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class ArcDoorExample extends GraphicsProgram{
	
	public void run() {
		
		ArcDoor door = new ArcDoor(DOOR_WIDTH, DOOR_HEIGHT);
		add(door, getWidth() / 2, getHeight() / 2);
		
	}
	
	public class ArcDoor extends GPolygon{
		
		public ArcDoor(double width, double height) {
			double verticalEdge = height - width / 2;
			addVertex(-width / 2, 0);
			addEdge(width, 0);
			addEdge(0, -verticalEdge);
			addArc(width, width, 0, 180);
			addEdge(0, verticalEdge);
		}
		
	}
	
	private static final double DOOR_WIDTH = 100;
	private static final double DOOR_HEIGHT = 150;

}
