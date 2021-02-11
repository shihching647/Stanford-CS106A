package assignment6.mvc;

import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.*;

public class TableView extends NameSurferView {
	
	public static final int PADDING = 15;
	
	public TableView() {
		
	}
	
	@Override
	public void drawBkGrid() {
		//draw vertical lines
		int width = getWidth();
		int height = getHeight();
		int space = width / (NDECADES + 1);
		//加背景
		GRect background = new GRect(width, GRAPH_MARGIN_SIZE);
		background.setFilled(true);
		background.setColor(Color.PINK.brighter());
		add(background, space, 0);
		
		for(int i = 0; i < NDECADES + 1; i++) {
			int x = i * space;
			if(i > 0) {
				//文字標籤
				GLabel label = new GLabel("" + (START_DECADE + (i - 1) * 10));
				label.setFont("Arial-bold-12");
				add(label, x + (space - label.getWidth()) / 2, PADDING);
			}
			add(new GLine(x, 0, x, height));
		}
		//draw horizontal lines
		add(new GLine(0, GRAPH_MARGIN_SIZE, width, GRAPH_MARGIN_SIZE));
		
	}

	@Override
	public void createGraph(ArrayList<NameSurferEntry> list) {
		//cell寬和高
		int cellHeight = GRAPH_MARGIN_SIZE;
		int cellWidth = getWidth() / (NDECADES + 1);
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < NDECADES + 1; j++) {
				int x = j * cellWidth;
				GLabel label;
				if(j == 0) {
					label = new GLabel(list.get(i).getName());
					label.setFont("Arial-bold-12");
				}else {
					int rank = list.get(i).getRank(j - 1);
					if(rank == 0) {
						label = new GLabel("None");
					}else {
						label = new GLabel(String.valueOf(rank));
					}
				}
				//設定顏色
				label.setColor(getColorForIndex(i));
				//將文字加到正確的位置
				add(label, x + (cellWidth - label.getWidth()) / 2, (i + 1) * cellHeight + PADDING);
				//畫下面格子的線
				add(new GLine(0, (i + 2) * cellHeight, getWidth(), (i + 2) * cellHeight));
			}
		}
		
	}

}
