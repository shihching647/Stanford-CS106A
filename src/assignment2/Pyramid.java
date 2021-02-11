package assignment2;/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		//x, y一開始是最下排第一塊的座標, index爲控制金字塔高度(用在裡面的for迴圈)
		double x = (getWidth() - (BRICKS_IN_BASE * BRICK_WIDTH)) / 2;
		double y = getHeight() - BRICK_HEIGHT;
		int index = BRICKS_IN_BASE;
		
		for(int i = 1; i <= BRICKS_IN_BASE; i++) {
			for(int j = 1; j <= index; j++) {
				add(new GRect(x + j * BRICK_WIDTH, y, BRICK_WIDTH,BRICK_HEIGHT));
			}
			//上排x座標加BRICK_WIDTH / 2, y座標減BRICK_HEIGHT, index減一
			x += BRICK_WIDTH / 2;
			y -= BRICK_HEIGHT;
			index--;
		}
	}
}

