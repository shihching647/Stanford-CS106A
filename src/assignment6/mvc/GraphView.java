package assignment6.mvc;
/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class GraphView extends NameSurferView {
	
	public static final int PADDING = 5;
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public GraphView() {

	}
	
	public void createGraph(ArrayList<NameSurferEntry> list) {
		if(list == null) return;
		for(int i = 0; i < list.size(); i++) {
			drawData(list.get(i), getColorForIndex(i), list);
		}
	}
	
	private void drawData(NameSurferEntry entry, Color color, ArrayList<NameSurferEntry> list) {
		GPoint[] points = new GPoint[NDECADES];
		int spaceX = getWidth() / NDECADES;
		double spaceY = getHeight() - 2 * GRAPH_MARGIN_SIZE;
		for(int i = 0; i < points.length; i++) {
			int x = i * spaceX;
			double y = GRAPH_MARGIN_SIZE + spaceY * entry.getRank(i) / 1000;
			if((int)y == GRAPH_MARGIN_SIZE) {
				y = GRAPH_MARGIN_SIZE + spaceY;
			}
			points[i] = new GPoint(x, y);
		}
		//draw lines
		for(int i = 0; i < points.length; i++) {
			//因為line只要畫10次, label要畫11次, 所以line要少畫一次,不然會超出範圍
			if(i < points.length - 1) {
				GLine line = new GLine(points[i].getX(), points[i].getY(), points[i+1].getX(), points[i+1].getY());
				line.setColor(color);
				add(line);
			}
			//draw labels
			GLabel label = new GLabel(entry.getName() + " " + ( entry.getRank(i) != 0 ? entry.getRank(i) : "*"));
			label.setColor(color);
			add(label, points[i]);
		}
		
	}

	public void drawBkGrid() {
		//draw vertical lines
		int width = getWidth();
		int height = getHeight();
		int space = width / NDECADES;
		for(int i = 0; i < NDECADES; i++) {
			int x = i * space;
			add(new GLine(x, 0, x, height));
			//add x座標
			GLabel label = new GLabel("" + (START_DECADE + i * 10));
			add(label, x + PADDING, height - PADDING);
		}
		//draw horizontal lines
		add(new GLine(0, GRAPH_MARGIN_SIZE, width, GRAPH_MARGIN_SIZE));
		add(new GLine(0, height - GRAPH_MARGIN_SIZE, width, height - GRAPH_MARGIN_SIZE));
	}
}
