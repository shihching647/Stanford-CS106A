/* File: Album.java
 * Keeps track of all the information for one album in the music shop,
 * including its name, the number in the stock, and the band that its by.
 */

package ch10.musicShop;

public class Album {
	
	public Album(String albumName, String bandName, int numStocked) {
		this.albumName = albumName;
		this.bandName = bandName;
		this.numStocked = numStocked;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public String getBandName() {
		return bandName;
	}
	
	public int getNumStocked() {
		return numStocked;
	}
	
	public String toString() {
		return ("\"" + albumName + "\" by " + bandName + ": " + numStocked + "in stock.");
	}
	
	//invars
	private String albumName;
	private String bandName;
	private int numStocked;
}
