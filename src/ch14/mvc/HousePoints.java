package ch14.mvc;
/*
 * File: HousePoints.java
 * ----------------------
 * This program displays the house points for the Hogwarts houses
 * in both a bar graph and a pie chart view.  The purpose of the
 * program is to illustrate the model/view/controller pattern
 * described in Chapter 14.  This version, however, is unfinished;
 * completion of the program appears as exercise 7.
 */

import acm.program.*;

import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.*;

public class HousePoints extends GraphicsProgram {
	
	public static final int BARVIEW_WIDTH = 200;
	public static final int BARVIEW_HEIGHT = 200;
	

	// You fill this in //
	public void init() {
		label = new JLabel("Points");
		add(label, SOUTH);
		
		field = new JTextField(20);
		add(field, SOUTH);
		field.addActionListener(this);
		
		btnGraph = new JButton("Graph");
		add(btnGraph, SOUTH);
		addActionListeners();
		
		model.addView(barView);
		model.addView(pieView);
		
		add(barView, getWidth() / 4 -  BARVIEW_WIDTH / 2, getHeight() / 2 - BARVIEW_HEIGHT / 2);
		add(pieView, 3 * getWidth() / 4 -  BARVIEW_WIDTH / 2, getHeight() / 2 - BARVIEW_HEIGHT / 2);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == btnGraph || src == field) {
			ArrayList<Integer> intList = getIntList();
			int [] points = toArray(intList);
			model.setHousePoints(points);
		}
	}


	private ArrayList<Integer> getIntList() {
		String line = field.getText();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		StringTokenizer tokenizer =  new StringTokenizer(line, ", ");
		while(tokenizer.hasMoreTokens()) {
			try {
				intList.add(Integer.parseInt(tokenizer.nextToken()));
			} catch(Exception ex) {
				continue;
			}
		}
		return intList;
	}


	private int[] toArray(ArrayList<Integer> arr) {
		int[] result = new int[arr.size()];
		for(int i = 0; i < arr.size(); i++) {
			result[i] = arr.get(i);
		}
		return result;
	}



	private JLabel label;
	private JTextField field;
	private JButton btnGraph;
	private HousePointsModel model = new HousePointsModel();
	private BarGraphView barView = new BarGraphView(BARVIEW_WIDTH, BARVIEW_HEIGHT);
	private PieChartView pieView = new PieChartView(BARVIEW_WIDTH, BARVIEW_HEIGHT);
}
