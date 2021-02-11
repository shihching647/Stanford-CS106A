package ch6;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class FilledRect6_8 extends GraphicsProgram{
	
	public void run() {
		add(new FilledRect(0, 0, getWidth() / 3, getHeight(), Color.BLUE));
		add(new FilledRect(getWidth() / 3, 0, getWidth() / 3, getHeight(), Color.WHITE));
		add(new FilledRect(getWidth() / 3 * 2, 0, getWidth() / 3, getHeight(), Color.RED));
	}
	/*
	 * This class is GObject subclass that is almost identical
	 * to GRect except that it starts out filled instead of
	 * outlined.
	 */
	public class FilledRect extends GRect{
		
		//Creates a new FilledRect with the specified bounds.
		public FilledRect(double x, double y, double width, double height) {
			super(x, y, width, height);
			setFilled(true);
		}
		//Creates a new FilledRect with the specified bounds and color.
		public FilledRect(double x, double y, double width, double height, Color color) {
			this(x, y, width, height);
			setFillColor(color);
		}

}
	//Set the dimensions of the window.
	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 500;

}
