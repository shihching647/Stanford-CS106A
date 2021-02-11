package ch14.mvc;
/*
 * File: HousePointsView.java
 * --------------------------
 * This abstract class defines the operations that any specific
 * view class must support.  Each HousePointsView is a GCompound
 * that responds to update messages from the model.
 */

import acm.graphics.*;
import java.awt.*;

public abstract class HousePointsView extends GCompound {

/** Creates a new HousePointsView with a given model and size */
	public HousePointsView(double width, double height) {
		background = new GRect(width, height);
		background.setFilled(true);
		background.setColor(Color.WHITE);
	}

/** Each subclass must define a method to create the graph */
	public abstract void createGraph(int[] data);

/** Updates the display image from the model */
	public void update(HousePointsModel model) {
		removeAll();
		add(background);
		createGraph(model.getHousePoints());
	}

/** Returns a color to use for the kth data value */
	public Color getColorForIndex(int k) {
		return COLORS[k % COLORS.length];
	}

/* Private constants */
	private static final Color[] COLORS = {
		 Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN,
		 Color.PINK, Color.CYAN, Color.MAGENTA, Color.ORANGE
	};

/* Private instance variables */
	private GRect background;
}
