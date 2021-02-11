package assignment3;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 5;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
//Delay time
	private static final int DELAY = 15;
	

/* Method: run() */
/** Runs the assignment3.Breakout program. */
	public void run() {
		initBricks();
		int life = NTURNS;
		while(life > 0) {
			setUpGame();
			playGame();
			if(isWin())  
				break;
			life--;
		}
		printResults();
	}
	
	private void setUpGame() {
		setUpPaddle();
		setUpBall();
	}
	
	private void playGame() {
		initBallVelociy();
		while(!gameOver()) {
			moveBall();
			checkCollision();
//			checkSideCollisionWithPaddle();
			pause(DELAY);
		}
		clearUp();
	}
	
	/**
	 * 初始化磚塊
	 */
	private void initBricks() {
		for(int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				int x = BRICK_SEP / 2+ j * (BRICK_WIDTH + BRICK_SEP);
				int y = BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP);
				add(createRect(x, y, BRICK_WIDTH, BRICK_HEIGHT, getColor(i)));
			}
		}
	}
	
	/**
	 * 產生一個填滿的矩形
	 * @param x 左上角x座標
	 * @param y 左上角y座標
	 * @param width 矩形的寬
	 * @param height 矩形的長
	 * @param color 矩形的顏色
	 * @return 一個填滿的矩形
	 */
	private GRect createRect(int x, int y, int width, int height, Color color) {
		GRect rect = new GRect(x, y, width, height);
		rect.setFillColor(color);
		rect.setFilled(true);
		return rect;
	}
	
	/**
	 * 產生磚塊的顏色
	 * @param i 第i排磚塊
	 * @return 磚塊的顏色
	 */
	private Color getColor(int i) {
		Color color = null;
		switch(i) {
			case 0: case 1: return color = Color.RED;
			case 2: case 3: return color = Color.ORANGE;
			case 4: case 5: return color = Color.YELLOW;
			case 6: case 7: return color = Color.GREEN;
			case 8: case 9: return color = Color.CYAN;
		}
		return color;
	}
	
	/**
	 * 產生下面的paddle,並加入mouse listeners使其可以跟著滑鼠移動
	 */
	private void setUpPaddle() {
		int x = (WIDTH - PADDLE_WIDTH) / 2;
		int y = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		paddle = createRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);
		add(paddle);
		addMouseListeners();
	}
	
	/**
	 * 移動paddle方法
	 */
	public void mouseMoved(MouseEvent e) {
		//移動paddle, last為移動的基準點
		double last = paddle.getX() + PADDLE_WIDTH / 2;
		paddle.move(e.getX() - last, 0);
		last = paddle.getX();
		//如果超過邊緣,把paddle設定在邊緣
		if(paddle.getX() + PADDLE_WIDTH > WIDTH) {
			paddle.setLocation(WIDTH - PADDLE_WIDTH - BRICK_SEP / 2, paddle.getY());
		}
		if(paddle.getX() < 0) {
			paddle.setLocation(BRICK_SEP / 2, paddle.getY());
		}
	}
	
	/**
	 * 在螢幕中央產生一顆球
	 */
	private void setUpBall() {
		ball = new GOval(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 -BALL_RADIUS, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
	}
	
	/**
	 * 設定球的出速度
	 */
	private void initBallVelociy() {
		vx = rgen.nextDouble(1.0, 3.0);
		if(rgen.nextBoolean(0.5)) vx = -vx;  //50%機率左, 50%機率往右
		vy = 3.0;
	}
	
	/**
	 * 讓球移動
	 */
	private void moveBall() {
		ball.move(vx, vy);
		checkBounceToWall();
	}
	
	/**
	 * 確認球有沒有碰到牆壁,有的話速度相反
	 */
	private void checkBounceToWall() {
		//上
		if(ball.getY() <= 0) {
			vy = -vy;
		}
		//左
		if(ball.getX() <= 0) {
			vx = -vx;
		}
		//右
		if(ball.getX() + 2 * BALL_RADIUS >= getWidth()) {
			vx = -vx;
		}
	}
	
	/**
	 * 確認球有沒有跟paddle或是磚塊碰到-->有的話,Vy相反
	 */
	private void checkCollision() {
		GObject collider = getCollidingObject();
		if(collider != null) {
			if(collider == paddle) {
				 //難!!!! 如果發生碰撞時球的下方再paddle下面,將球的Y座標設定為paddle的Y座標
			      if (ball.getY() + 2 * BALL_RADIUS > paddle.getY())
			         ball.setLocation(ball.getX(), paddle.getY() - (2 * BALL_RADIUS));
				vy = -vy;
			}
			else {
				vy = -vy;
				remove(collider);
				bricksCount++;  //用來追中bricks被打中幾顆
			}
		}
	}
	
	/**
	 * 回傳與球的四個點發生碰撞的物件
	 * @return 與球發生碰撞的GObject
	 */
	private GObject getCollidingObject() {
		GObject collider1 = getElementAt(ball.getX(), ball.getY());
		GObject collider2 = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());
		GObject collider3 = getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		GObject collider4 = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		
		if(collider1 != null) return collider1;
		else if(collider2 != null) return collider2;
		else if(collider3 != null) return collider3;
		else if(collider4 != null) return collider4;
		else return null;
	}
	
//	private void checkSideCollisionWithPaddle() {
//		GObject colliderLeft = null, colliderRight = null;
//		for(int i = 0; i < 2 * BALL_RADIUS - 1; i++) {
//			colliderLeft = getElementAt(ball.getX() - 1, ball.getY() + i);
//			colliderRight = getElementAt(ball.getX() + 1 + 2 * BALL_RADIUS, ball.getY() + i);
//			if(colliderLeft != null || colliderRight != null) {
//				vx = -vx;
//				break;
//			}
//		}
//	}
	
	/**
	 * 確認遊戲是否結束,1.球掉到螢幕下方.2.磚塊都打完了
	 * @return true表示結束,false表示沒結束
	 */
	private boolean gameOver() {
		return ((ball.getY() >= getHeight() || isWin()));
	}
	
	/**
	 * 確認磚塊是否打完
	 * @return true表示贏了,false表示還沒贏
	 */
	private boolean isWin() {
		return bricksCount == (NBRICK_ROWS * NBRICKS_PER_ROW);
	}
	
	/**
	 * 清空paddle和球
	 */
	private void clearUp() {
		remove(paddle);
		remove(ball);
		paddle = null;
		ball = null;
	}
	
	/**
	 * 印出遊戲結束的結果
	 */
	private void printResults() {
		GLabel result;
		if(isWin()) {
			result = new GLabel("YOU WIN!!!");
			result.setColor(Color.BLUE);
		}
		else {
			result = new GLabel("YOU LOSE!!!");
			result.setColor(Color.RED);
		}
		result.setFont("Dialog-64");
		add(result, (getWidth() - result.getWidth()) / 2, (getHeight() + result.getAscent()) / 2);
	}
	
	//private instance variables
	private GRect paddle;
	private GOval ball;
	private double vx, vy; //the velocity of ball
	private int bricksCount = 0;  //用來追中bricks被打中幾顆
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
