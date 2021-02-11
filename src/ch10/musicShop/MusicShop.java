package ch10.musicShop;

import acm.program.*;
import acm.graphics.*;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class MusicShop extends Program{
	
	public void init() {
		label = new JLabel("Album Name: ");
		add(label, SOUTH);
		
		albumName = new JTextField(20);
		add(albumName, SOUTH);
		albumName.addActionListener(this);
		
		canvas = new MusicShopDisplay();
		add(canvas);
		
		loadInventory();
		
		addActionListeners();
		
	}
	
	
	private void loadInventory() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("src/ch10/MusicShop/music-data.txt"));
			
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				Album album = parseLine(line);
				inventory.put(album.getAlbumName(), album);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//[Snakes and Arrows] [Rush] 10
	private Album parseLine(String line) {
		//取出albumName
		int albumNameStart = line.indexOf('[') + 1;
		int albumNameEnd = line.indexOf(']');
		String albumName = line.substring(albumNameStart, albumNameEnd);
		//取出bandName
		int bandNameStart = line.indexOf('[', albumNameEnd) + 1;
		int bandNameEnd = line.indexOf(']', albumNameEnd + 1);
		String bandName = line.substring(bandNameStart, bandNameEnd);
		//取出numStocked
		int numStockedStart = line.indexOf(' ', bandNameEnd) + 1;
		int numStocked = Integer.parseInt(line.substring(numStockedStart));
		
		return new Album(albumName, bandName, numStocked);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == albumName) {
			canvas.displayInventory(inventory.get(albumName.getText()));
		}
	}


	//invars
	private JLabel label;
	private JTextField albumName;
	private MusicShopDisplay canvas;
	private HashMap<String, Album> inventory = new HashMap<String, Album>();
}
