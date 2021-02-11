package ch10;/*
 * File:DrawStarMap_GUI
 * Purpose:滑鼠點一下可產生一顆星星/菱形/六邊形, 下方GUI可選擇星星的顏色,大小,是否填滿還有清除
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;  //addMouseListeners()要import addMouseListeners()
import javax.swing.*;


public class DrawMap_GUI extends GraphicsProgram{

	public void init() {
		setBackground(new Color(0xd3, 0xd3, 0xd3));
		//JButton - Clear
		JButton clear = new JButton("Clear");
		add(clear, SOUTH);
		
		//JCheckBox - Filled
		fillCheckBox = new JCheckBox("Filled");
		fillCheckBox.setSelected(true);
		add(fillCheckBox, SOUTH);
		
		//JRadioBox - 形狀(先建立3個JRadioButton,再用ButtonGroup將他們合併再一起)
//		ImageIcon diamond = new ImageIcon("diamond.png");
//		ImageIcon hexagon = new ImageIcon("hexagon.png");
//		ImageIcon star = new ImageIcon("star.png");
		diamondButton = new JRadioButton("Diamond");
		hexagonButton = new JRadioButton("Hexagon");
		starButton = new JRadioButton("Star");
		ButtonGroup shapeGroup = new ButtonGroup();
		shapeGroup.add(diamondButton);
		shapeGroup.add(hexagonButton);
		shapeGroup.add(starButton);
		add(diamondButton, SOUTH);
		add(hexagonButton, SOUTH);
		add(starButton, SOUTH);
		diamondButton.setSelected(true);
		
		//JSlider & JLabel
		//JSlider(int 最小值, int 最大值, int 初始值)
		sizeSlider = new JSlider((int)(SIZE_SMALL), (int)(SIZE_LARGE), (int)(SIZE_MEDIUM));
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
		if(e.getActionCommand().equals("Clear"))
			removeAll();
	}
	
	public void mousePressed(MouseEvent e) {
		GPolygon obj = getStarShape();
		obj.setFilled(fillCheckBox.isSelected());
		obj.setFillColor(getCurrentColor());
		add(obj, e.getX(), e.getY());
	}
	
	private GPolygon getStarShape() {
		if(diamondButton.isSelected())
			return GShape.GDiamond(getCurrentSize(), getCurrentSize() * 1.2);
		if(hexagonButton.isSelected())
			return GShape.GHexagon(getCurrentSize() / 2); //因為六邊形的寬 = 2倍邊長
		return GShape.GStar(getCurrentSize());
	}
	
	private double getCurrentSize() {
		return sizeSlider.getValue();
	}
	
	//JComboBox
	private void initColorChooser() {
		colorChooser = new JComboBox<String>();
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
		if(name.equals("Pink")) return new Color(0xFF, 0x00, 0xFF);
		if(name.equals("Purple")) return new Color(0x8A, 0x2B, 0xE2);
		return Color.WHITE;
	}

	private static final double SIZE_SMALL = 30;
	private static final double SIZE_MEDIUM = 60;
	private static final double SIZE_LARGE = 90;
	private JCheckBox fillCheckBox;
	private JRadioButton diamondButton, hexagonButton, starButton;
	private JSlider sizeSlider;
	private JComboBox<String> colorChooser;
}