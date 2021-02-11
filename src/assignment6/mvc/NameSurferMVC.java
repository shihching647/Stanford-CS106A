package assignment6.mvc;
/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurferMVC extends Program implements NameSurferConstants, ComponentListener {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		//初始化GUI
		label = new JLabel("Name");
	    add(label, SOUTH);

	    textField = new JTextField(20);
	    add(textField, SOUTH);
	    textField.addActionListener(this);
	   
	    btnGraph = new JButton("Graph");
	    btnTable = new JButton("Table");
	    btnClear = new JButton("Clear");
	    add(btnGraph, SOUTH);
	    add(btnTable, SOUTH);
	    add(btnClear, SOUTH);
	    addActionListeners();
	    
	    //初始化databaseModel
		model = new NameSurferModel(NAMES_DATA_FILE);
		view = new GraphView();
		model.addView(view);
		add(view);
		table = new TableView();
		model.addView(table);
		add(table);
		addComponentListener(this);
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnGraph || source == textField) {
			String name = textField.getText().trim();
			model.addEntry(model.getDataBase().findEntry(name));
			textField.setText("");
		}else if(source == btnTable) {
			if(table == null) {
				table = new TableView();
				model.addView(table);
				add(table);
			}else {
				remove(table);
				model.removeView(table);
				table = null;
			}
		}else if(source == btnClear) {
			model.clear();
		}
	}
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { 
		model.notifyViews();
	}
	public void componentShown(ComponentEvent e) { }

	
	//invars
	private JLabel label;
	private JTextField textField;
	private JButton btnGraph, btnTable, btnClear;
	private NameSurferModel model;
	private GraphView view;
	private TableView table;
}
