package ch10;/*
 * File:DragObjects
 * Purpose:可將物間拖曳,Click mouse可將物件移到最上層
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;


public class DragObjects10_4 extends GraphicsProgram{

	public void init() {
		GRect rect = new GRect(100, 150, 200, 200);
		rect.setFilled(true);
		rect.setFillColor(Color.RED);
		add(rect);
		GOval c = new GOval(100, 150, 200, 200);
		c.setFilled(true);
		c.setFillColor(Color.BLUE);
		add(c);
		addMouseListeners();
		addKeyListeners();  //增加對鍵盤的反應
	}
	
	//按下滑鼠,取得那個點並將那個點上的物件存入gobj,若無物件->gobj = null
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
	
	//點一下滑鼠 將物件移到最上層
	public void mouseClicked(MouseEvent e) {
		if(gobj != null) gobj.sendToFront();
	}
	
	//鍵盤的上下左右可以微調物件
	public void keyPressed(KeyEvent e) {
		if(gobj != null) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_UP: gobj.move(0, -1); break;
				case KeyEvent.VK_DOWN: gobj.move(0, 1); break;
				case KeyEvent.VK_LEFT: gobj.move(-1, 0); break;
				case KeyEvent.VK_RIGHT: gobj.move(1, 0); break;
			}
		}
	}
	
	
	private GPoint last;
	private GObject gobj;
}