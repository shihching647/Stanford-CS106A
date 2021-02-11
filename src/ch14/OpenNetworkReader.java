package ch14;/*
 * File: OpenNetworkReader.java
 * ----------------------------
 * This program opens a network URL and displays the contents of
 * that URL on the console as if it were a text file.
 */

import acm.program.*;
import java.io.*;
import java.net.*;

/**
 * This program opens a network URL and displays the contents of
 * that URL on the console as if it were a text file.  Thus, if
 * you enter the address of a web page, this program will display
 * the HTML source.
 */
public class OpenNetworkReader extends ConsoleProgram {

	public void run() {
		try {
			BufferedReader rd = openNetworkReader("Enter URL: ");
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				println(line);
			}
			rd.close();
		} catch (IOException ex) {
			/* Empty */
		}
	}

/*
 * Asks the user for a network address and then opens that URL
 * to obtain a BufferedReader on the contents.  If the URL
 * cannot be opened, the method allows the user to enter a
 * different URL.  The prompt argument specifies the message
 * displayed to the user asking for a URL.
 */
	private BufferedReader openNetworkReader(String prompt) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				URL url = new URL(readLine(prompt));
				InputStream in = url.openStream();
				rd = new BufferedReader(new InputStreamReader(in));
			} catch (IOException ex) {
				println("Can't open that URL.");
			}
		}
		return rd;
	}

}
