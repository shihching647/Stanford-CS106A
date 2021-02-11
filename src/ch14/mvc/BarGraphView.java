package ch14.mvc;
/*
 * File: BarGraphView.java
 * -----------------------
 * This class represents a concrete implementation of the
 * HousePointsView class that builds a bar chart.  The chart is
 * scaled so that the maximum value fills the vertical space.
 */

import acm.graphics.*;

public class BarGraphView extends HousePointsView {

/** Creates a new BarGraphView */
	public BarGraphView(double width, double height) {
		super(width, height);
	}

/** Arranges the data as a set of bars */
	public void createGraph(int[] data) {
		int n = data.length;
		double max = maxIntArray(data);
		if (max == 0) return;
		
		double sep = (getWidth() - n * BAR_WIDTH) / (n + 1);
		for (int i = 0; i < n; i++) {
			double height = data[i] / max * getHeight();
			double x = i * (BAR_WIDTH + sep);
			double y = getHeight() - height;
			GRect bar = new GRect(x, y, BAR_WIDTH, height);
			bar.setFilled(true);
			bar.setFillColor(getColorForIndex(i));
			add(bar);
		}
	}

/* Returns the maximum value of an integer array (or 0 if empty) */
	private int maxIntArray(int[] array) {
		if (array.length == 0) return 0;
		int largest = array[0];
		for (int i = 1; i < array.length; i++) {
			largest = Math.max(largest, array[i]);
		}
		return largest;
	}

/* Private constants */
	private static final double BAR_WIDTH = 20;

}
