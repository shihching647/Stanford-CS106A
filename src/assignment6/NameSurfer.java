package assignment6;/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

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
	    btnClear = new JButton("Clear");
	    add(btnGraph, SOUTH);
	    add(btnClear, SOUTH);
	    addActionListeners();
	    
	    //初始化database
	    try {
			db = new NameSurferDataBase(NAMES_DATA_FILE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    //初始化Graph
	    graph = new NameSurferGraph();
	    add(graph);
	    
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
			graph.addEntry(db.findEntry(name));
			textField.setText("");
		}else if(source == btnClear) {
			graph.clear();
		}
	}
	
	//invars
	private JLabel label;
	private JTextField textField;
	private JButton btnGraph, btnClear;
	private NameSurferDataBase db;
	private NameSurferGraph graph;
}
