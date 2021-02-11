package assignment6;/*
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

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {
	
	public static final int PADDING = 5;
	public static final Color[] COLORS = {Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA};
	private ArrayList<NameSurferEntry> list;

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		list = new ArrayList<NameSurferEntry>();
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		//	 You fill this in //
		list.clear();
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
		if(entry != null) {
			list.add(entry);
			update();
		}
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawBkGrid();
		for(int i = 0; i < list.size(); i++) {
			drawData(list.get(i), COLORS[i % COLORS.length]);
		}
	}
	
	
	
	
	private void drawData(NameSurferEntry entry, Color color) {
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

	private void drawBkGrid() {
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

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
