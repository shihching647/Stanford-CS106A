package ch4;/*
 * File: Checkboard
 * Purpose: 畫出一個西洋棋盤格(8x8),其高度剛好符合視窗的高
 */

import acm.program.*;
import acm.graphics.*;

public class Checkerboard4_9 extends GraphicsProgram{
	
	public void run(){
		double size = (double)(getHeight() / N_ROWS);
		
		for(int i = 0; i < N_ROWS; i++) {
			for(int j = 0; j < N_COLUMN; j++) {
				double X = j * size;
				double Y = i * size;
				GRect graph = new GRect(X, Y, size, size);
				graph.setFilled((i + j) % 2 == 1);
				add(graph);
			}
		}
	}
	
	private static final int N_ROWS = 8;
	private static final int N_COLUMN = 8;
}
	
