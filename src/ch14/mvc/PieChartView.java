package ch14.mvc;
/*
 * File: PieChartView.java
 * -----------------------
 * This class represents a concrete implementation of the
 * GraphView class that builds a pie chart.  The details
 * of the implementation are left to you as an exercise.
 */

import acm.graphics.*;

public class PieChartView extends HousePointsView {

/** Creates a new PieChartView */
	public PieChartView(double width, double height) {
		super(width, height);
	}

/** Arranges pie-shaped wedges around the center of the figure */
	public void createGraph(int[] data) {
		// You fill this in //
		int n = data.length;
		double max = maxIntArray(data);
		double sum = sumIntArray(data);
		if(max == 0) return;
		double degreeStar = 0;
		for(int i = 0; i < n; i++) {
			double degree =  ROUND_DEGREE * data[i] / sum;
			GArc arc = new GArc(RADIUS, RADIUS, degreeStar, degree);
			degreeStar += degree;
			arc.setFilled(true);
			arc.setFillColor(getColorForIndex(i));
			add(arc);
		}
	}

	
	private double sumIntArray(int[] array) {
		if (array.length == 0) return 0;
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	private int maxIntArray(int[] array) {
		if (array.length == 0) return 0;
		int largest = array[0];
		for (int i = 1; i < array.length; i++) {
			largest = Math.max(largest, array[i]);
		}
		return largest;
	}
	
	private static final double ROUND_DEGREE = 360;
	private static final double RADIUS = 200;
}
