package assignment6.mvc;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import acm.graphics.*;

public abstract class NameSurferView extends GCanvas implements NameSurferConstants{
	
	public static final Color[] COLORS = {Color.RED, Color.GREEN.darker(), Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.BLACK};
	
	public abstract void drawBkGrid();
	public abstract void createGraph(ArrayList<NameSurferEntry> list);
	
	public void update(NameSurferModel model) {
			removeAll();
			drawBkGrid();
			createGraph(model.getEntries());
	}
	
	public Color getColorForIndex(int k) {
		return COLORS[k % COLORS.length];
	}
	
}
