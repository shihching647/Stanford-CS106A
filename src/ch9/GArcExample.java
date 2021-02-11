package ch9;/*
 * File:GArcExample
 * Purpose: 產生一個分成4等分的Pizza形狀,且每一等分顏色不一樣(用RandomGenerator)
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import acm.util.*;

public class GArcExample extends GraphicsProgram {
	
	public void run() {
		int r = 100;
		double x = (getWidth() - 2 * r) / 2;
		double y = (getHeight() - 2 * r) / 2;
		GArc arc1 = new GArc(x, y, 2 * r, 2 * r, 0, 90);
		GArc arc2 = new GArc(x, y, 2 * r, 2 * r, 90, 90);
		GArc arc3 = new GArc(x, y, 2 * r, 2 * r, 180, 90);
		GArc arc4 = new GArc(x, y, 2 * r, 2 * r, 270, 90);
		arc1.setFilled(true);
		arc2.setFilled(true);
		arc3.setFilled(true);
		arc4.setFilled(true);
		arc1.setFillColor(rgen.nextColor());
		arc2.setFillColor(rgen.nextColor());
		arc3.setFillColor(rgen.nextColor());
		arc4.setFillColor(rgen.nextColor());
		add(arc1);
		add(arc2);
		add(arc3);
		add(arc4);
	
	}
	
	private RandomGenerator rgen = 	RandomGenerator.getInstance();

}
