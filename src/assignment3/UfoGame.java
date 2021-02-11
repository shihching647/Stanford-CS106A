package assignment3;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class UfoGame extends GraphicsProgram{
	
	//Size and speed of UFO
	private static final int UFO_WIDTH = 40;
	private static final int UFO_HEIGHT = UFO_WIDTH / 2;
	private static final int UFO_SPEED = 5;
	
	//Size and speed of bullet
	private static final int BULLET_SPEED = 10;
	private static final int BULLET_DIAM = 5;
	
	//Animation cycle delay
	private static final int DELAY = 10;
	
	public void run() {
		setup();
		while(!gameOver()) {
			moveUFO();
			moveBullet();
			checkCollision();
			pause(DELAY);
		}
	}
	
	/**
	 * setup UFO and add mouse listeners
	 */
	private void setup() {
		ufo = new GRect(UFO_WIDTH, UFO_HEIGHT);
		ufo.setFilled(true);
		add(ufo, getWidth() - UFO_WIDTH, 0);
		ufoToLeft = true;
		addMouseListeners();
	}
	
	/**
	 * determines if game is over - true if either the UFO is destroyed or if the UFO lands
	 * @return boolean show if game is over or not
	 */
	private boolean gameOver() {
		return( ufo == null || ufo.getY() + UFO_HEIGHT >= getHeight());
	}
	
	/**
	 * move UFO, if UFO moved to edge of screen, moves UFO down
	 * and changes UFO direction
	 */
	private void moveUFO() {
		if(ufoToLeft) {
			ufo.move(-UFO_SPEED, 0);
			if(ufo.getX() <= 0) {
				ufoToLeft = false;
				ufo.move(0, UFO_HEIGHT);
			}
		}else {
			ufo.move(UFO_SPEED, 0);
			if(ufo.getX() + UFO_WIDTH >= getWidth()) {
				ufoToLeft = true;
				ufo.move(0, UFO_HEIGHT);
			}
		}
	}
	
	/**
	 * when mouse is clicked create a bullet, unless bullet already exists
	 */
	public void mousePressed(MouseEvent e) {
		if(bullet == null) {
			bullet = new GOval(BULLET_DIAM, BULLET_DIAM) ;
			bullet.setFilled(true);
			bullet.setFillColor(Color.RED);
			add(bullet, (getWidth() - BULLET_DIAM) / 2, getHeight() - BULLET_DIAM);
		}
	}
	
	/**
	 * moves bullet. If bullet goes out off screen, remove bullet.
	 */
	private void moveBullet() {
		if(bullet != null) {
			if(bullet.getY() - BULLET_DIAM > 0) {
				bullet.move(0, -BULLET_SPEED);
			}else {
				remove(bullet);
				bullet = null;
			}
		}
	}
	
	/**
	 * checks to see if UFO and bullet collide, if so
	 * bullet and UFO are removed and both variables are
	 * set to null.
	 */
	private void checkCollision() {
		if(bullet != null) {
			GObject collisionObject = getElementAt(bullet.getX(), bullet.getY());
			if(collisionObject == ufo) {
				remove(ufo);
				
				remove(bullet);
				ufo = null;
				bullet = null;
			}
		}
	}
	
	//private instance variables.
	private GRect ufo;
	private GOval bullet;
	private boolean ufoToLeft; //when true, UFO is moving left

}
