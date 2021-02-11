package ch10;/*
 * File:DrawStarMap_GUI
 * Purpose:滑鼠點一下可產生一顆星星, 下方GUI可選擇星星的顏色,大小,是否填滿還有清除
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;  //addMouseListeners()要import addMouseListeners()
import javax.swing.*;


public class DrawStarMap_GUI_10_9 extends GraphicsProgram{

	public void init() {
		setBackground(Color.GRAY);
		//JButton - Clear
		 clear = new JButton("Clear");
		add(clear, SOUTH);
		
		//JCheckBox - Filled
		fillCheckBox = new JCheckBox("Filled");
		fillCheckBox.setSelected(true);
		add(fillCheckBox, SOUTH);
		
		//JRadioBox - Size(先建立3個JRadioButton,再用ButtonGroup將他們合併再一起)
//		smallButton = new JRadioButton("Small");
//		mediumButton = new JRadioButton("Medium");
//		largeButton = new JRadioButton("Large");
//		ButtonGroup sizeGroup = new ButtonGroup();
//		sizeGroup.add(smallButton);
//		sizeGroup.add(mediumButton);
//		sizeGroup.add(largeButton);
//		add(smallButton, SOUTH);
//		add(mediumButton, SOUTH);
//		add(largeButton, SOUTH);
//		mediumButton.setSelected(true);
		
		//JSlider & JLabel
		//JSlider(int 最小值, int 最大值, int 初始值)
		sizeSlider = new JSlider((int)(STAR_SIZE_SMALL), (int)(STAR_SIZE_LARGE),
				(int)(STAR_SIZE_MEDIUM));
		add(new JLabel(" Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large"), SOUTH);
		
		//JComboBox
		initColorChooser();
		add(colorChooser, SOUTH);

		addActionListeners();
		addMouseListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		//可用getActionCommand()
//		if(e.getActionCommand().equals("Clear"))
//			removeAll();
		//可用getSource()
		if(e.getSource() == clear)
			removeAll();
	}
	
	public void mouseClicked(MouseEvent e) {
		GStar star = new GStar(getCurrentSize());
		star.setFilled(fillCheckBox.isSelected());
		star.setFillColor(getCurrentColor());
		add(star, e.getX(), e.getY());
	}
	
//	private double getStarSize() {
//		if(smallButton.isSelected()) return STAR_SIZE_SMALL;
//		else if (mediumButton.isSelected()) return STAR_SIZE_MEDIUM;
//		else return STAR_SIZE_LARGE;
//	}
	
	private double getCurrentSize() {
		return sizeSlider.getValue();
	}
	
	//JComboBox
	private void initColorChooser() {
		colorChooser = new JComboBox();
		colorChooser.addItem("White");
		colorChooser.addItem("Red");
		colorChooser.addItem("Orange");
		colorChooser.addItem("Yellow");
		colorChooser.addItem("Green");
		colorChooser.addItem("Blue");
		colorChooser.addItem("Black");
		colorChooser.addItem("Pink");
		colorChooser.addItem("Purple");
		colorChooser.setEditable(false);  //讓使用者不能自己輸入
		colorChooser.setSelectedItem("White"); //預設值
	}
	
	private Color getCurrentColor() {
		String name = (String) colorChooser.getSelectedItem();
		if(name.equals("Red")) return Color.RED;
		if(name.equals("Orange")) return Color.ORANGE;
		if(name.equals("Yellow")) return Color.YELLOW;
		if(name.equals("Green")) return Color.GREEN;
		if(name.equals("Blue")) return Color.BLUE;
		if(name.equals("Black")) return Color.BLACK;
		if(name.equals("Pink")) return Color.PINK;
		if(name.equals("Purple")) return new Color(0x80, 0x00, 0x80);
		return Color.WHITE;
	}

	private static final double STAR_SIZE_SMALL = 20;
	private static final double STAR_SIZE_MEDIUM = 35;
	private static final double STAR_SIZE_LARGE = 50;
	private JButton clear;
	private JCheckBox fillCheckBox;
//	private JRadioButton smallButton, mediumButton, largeButton;
	private JSlider sizeSlider;
	private JComboBox colorChooser;
}