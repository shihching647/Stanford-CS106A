package ch10.musicShop;

import acm.graphics.*;
import java.awt.event.*;

public class MusicShopDisplay extends GCanvas implements ComponentListener{
	
	public MusicShopDisplay(){
		addComponentListener(this);
		lastAlbum = null;
	}
	
	public void displayInventory(Album album) {
		removeAll();
		lastAlbum = album;
		if(album != null) {
			int numStocked = album.getNumStocked();
			//加文字
			GLabel infor = new GLabel("Album [" + album.getAlbumName() + "] by [" + album.getBandName() + "]");
			infor.setFont("Dialog-18");
			add(infor, X_START, (getHeight() - BAR_HEIGHT) / 2 - SPACER);
			//Display squares indicating how many inventory
			double nextX = SPACER;
			for(int i = 0; i < numStocked; i++) {
				double barLength = getWidth() / (double)MAX_INVENTORY - SPACER;
				GRect rect = new GRect(barLength, BAR_HEIGHT);
				rect.setFilled(true);
				add(rect, nextX, (getHeight() - BAR_HEIGHT) / 2);
				nextX += SPACER + barLength;
			}
			GLabel label = new GLabel(numStocked + " in Stock");
			label.setFont("Dialog-18");
			add(label, X_START, (getHeight() + BAR_HEIGHT) / 2 + SPACER + label.getAscent());
		}
		
	}
	
	private void update() {
		displayInventory(lastAlbum);
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		update();
	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

	private static final double BAR_HEIGHT = 20;
	private static final double SPACER = 10;
	private static final double X_START = 10;
	private static final double MAX_INVENTORY = 20;

	private Album lastAlbum;

}
