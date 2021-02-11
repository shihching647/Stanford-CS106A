package ch9;/*
 * File:BouncingBall
 * Purpose:BouncingBall模擬
 */

import acm.graphics.*;
import acm.program.*;


public class BouncingBall extends GraphicsProgram{
	
	public void run() {
		
		setup();
		
		//Simulate until the ball reached the end of the canvas
		while(ball.getX() < getWidth()) {
			moveBall();
			checkCollision();
			pause(DELAY);
		}

	}
	/**
	 * Set a ball on the starting location
	 */
	private void setup() {
		ball = new GOval(X_START, Y_START,DIAM_BALL, DIAM_BALL);
		ball.setFilled(true);
		add(ball);
	}
	/**
	 * move ball, X方向為速度xVel的等速度運動,Y方向是a = GRAVITY的等加速度運動
	 */
	private void moveBall() {
		yVel += GRAVITY;
		ball.move(xVel, yVel);
	}
	
	private void checkCollision() {
		/**
		 * 檢查是否撞到地板(撞到地板:ball的Y座標 + Ball的大小 > 螢幕高度)
		 * 1.若撞到地板1.yVel = -yVel * BOUNCE_REDUCE(速度改變方向且減少)
		 * 2.撞到地板當時跑到螢幕外的量 (diff)= 反彈的高度
		 */
		if(ball.getY() + DIAM_BALL > getHeight()) {
			yVel = -yVel * BOUNCE_REDUCE;
			double diff = (ball.getY() + DIAM_BALL) - getHeight();
			ball.move(0,  -2 * diff);
		}
	}
	
	/** Size (diameter) of the ball */
	private static final int DIAM_BALL = 30;
	
	/** Amount Y velocity is increased each cycle as a result gravity */
	private static final double GRAVITY = 3;
	
	/** Animation delay or pause time between ball moves */
	private static final int DELAY = 50;
	
	/** Initial X and Y location of ball */
	private static final double X_START = DIAM_BALL / 2;
	private static final double Y_START = 100;
	
	/** X velocity */
	private static final double X_VEL = 5;
	
	/** Amount Y Velocity is reduced when it bounces */
	private static final double BOUNCE_REDUCE = 0.9;
	
	/** Starting X and Y Velocity */
	private static final double xVel = X_VEL;
	private static double yVel = 0;
	
	/** private instance variable */
	private GOval ball;
	
}
