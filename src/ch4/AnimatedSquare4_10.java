package ch4;/*
 * File: AnimatedSquare
 * Purpose: 畫出一個size = 50x50的正方形,從左上角移動到右下角.
 * Hint: 使用pause(time)來控制程式停止的時,造成動畫的錯覺
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class AnimatedSquare4_10 extends GraphicsProgram{
	
	public void run(){
		//Creat Square
		GRect Square = new GRect(0, 0, SIZE, SIZE);
		Square.setFilled(true);
		Square.setFillColor(Color.GREEN);
		add(Square);
		//Make Square move
		double dx = (getWidth() - SIZE) / STEPS;  //SIZE是double,double!!!! 若SIZE定義成int,算出來dx會是整數(錯誤！！）
		double dy = (getHeight() - SIZE) / STEPS;
		/*  這裏是用來debug的. 遇到問題：隨著STEPS變大,dy變成0(原因：dy算出來是int要用成double！！！）
		 * String sx = String.valueOf(dx);
		 * String sy = String.valueOf(dy);
		 * add(new GLabel(sx + " and "+ sy, 100, 100));
		 * */
		for(int i = 1; i <= STEPS; i++) {
			Square.move(dx, dy);
			pause(PAUSE_TIME);
		}
		
	}
	
	private static final double SIZE = 100;  //重要重要重要！！！！！要定義成double
	private static final int PAUSE_TIME = 10;
	private static final int STEPS = 1000;
}
	
