package ch10;/*
 * File:DragObjects
 * Purpose:可將物間拖曳,Click mouse可將物件移到最上層
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;


public class DrawAndDragStar extends GraphicsProgram{

	public void init() {
		addMouseListeners();
	}
	
	//按下滑鼠,取得那個點並將那個點上的物件存入gobj,若無物件->產生一個star
	public void mouseClicked(MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
		if(gobj == null) {
			GStar star = new GStar(STAR_SIZE);
			star.setFilled(true);
			star.setFillColor(Color.YELLOW);
			add(star, e.getX(), e.getY());
		}
	}
	
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
	
	//如果有物件才可以移動
	public void mouseDragged(MouseEvent e) {
		if(gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	

	private GPoint last;
	private GObject gobj;
	private static final double STAR_SIZE = 30;
}