package assignment4;/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.util.ArrayList;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		addScaffold();
		numOfGuess = 8;
		guess = "";
	}
	//畫出平台
	private void addScaffold() {
		GPoint p1 = new GPoint(getWidth() / 2 - BEAM_LENGTH, getHeight() / 2 + LEG_LENGTH);
		GPoint p2 = new GPoint(p1.getX(), p1.getY() - SCAFFOLD_HEIGHT);
		GPoint p3 = new GPoint(p2.getX() + BEAM_LENGTH, p2.getY());
		GPoint p4 = new GPoint(p3.getX(), p2.getY() + ROPE_LENGTH);
		add(new GLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
		add(new GLine(p3.getX(), p3.getY(), p2.getX(), p2.getY()));
		add(new GLine(p3.getX(), p3.getY(), p4.getX(), p4.getY()));
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		//移除本來的文字
		if(answerLabel != null) {
			remove(answerLabel);
		}
		//貼上新的文字
		answerLabel = new GLabel(word);
		answerLabel.setFont("Dialog-36");
		int x = getWidth() / 2 - BEAM_LENGTH;
		add(answerLabel, x - answerLabel.getWidth() / 2, getHeight() / 4 * 3);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		//移除本來的文字
		if(guessLabel != null)
			remove(guessLabel);
		//貼上新的文字
		guess += letter;
		guessLabel = new GLabel(guess);
		guessLabel.setFont("Serif-18");
		int x = getWidth() / 2 - BEAM_LENGTH;
		add(guessLabel, x - answerLabel.getWidth() / 2, getHeight() / 4 * 3 + answerLabel.getDescent() + guessLabel.getHeight());
		//更新圖
		updateHangman(guess);
	}
	
	//畫出圖形
	private void updateHangman(String guess) {
		int n = guess.length();
		switch(n) {
			case 1: addHead(); break;
			case 2: addBody(); break;
			case 3: addLeftHand(); break;
			case 4: addRightHand(); break;
			case 5: addLeftLeg(); break;
			case 6: addRightLeg(); break;
			case 7: addLeftFoot(); break;
			case 8: addRightFoot(); break;
		}
	}

	private void addHead() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		int x = xc - HEAD_RADIUS;
		int y = yc - BODY_LENGTH - ARM_OFFSET_FROM_HEAD - 2 * HEAD_RADIUS;
		add(new GOval(x, y, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS));
	}
	
	private void addBody() {
		add(new GLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2 - BODY_LENGTH - ARM_OFFSET_FROM_HEAD));
	}
	
	private void addLeftHand() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		GPoint p1 = new GPoint(xc, yc - BODY_LENGTH);
		GPoint p2 = new GPoint(xc - UPPER_ARM_LENGTH, yc - BODY_LENGTH);
		GPoint p3 = new GPoint(xc - UPPER_ARM_LENGTH, yc - BODY_LENGTH + LOWER_ARM_LENGTH);
		add(new GLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
		add(new GLine(p3.getX(), p3.getY(), p2.getX(), p2.getY()));
	}
	
	private void addRightHand() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		GPoint p1 = new GPoint(xc, yc - BODY_LENGTH);
		GPoint p2 = new GPoint(xc + UPPER_ARM_LENGTH, yc - BODY_LENGTH);
		GPoint p3 = new GPoint(xc + UPPER_ARM_LENGTH, yc - BODY_LENGTH + LOWER_ARM_LENGTH);
		add(new GLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
		add(new GLine(p3.getX(), p3.getY(), p2.getX(), p2.getY()));
	}
	
	private void addLeftLeg() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		GPoint p1 = new GPoint(xc, yc);
		GPoint p2 = new GPoint(xc - HIP_WIDTH, yc);
		GPoint p3 = new GPoint(xc - HIP_WIDTH, yc + LEG_LENGTH);
		add(new GLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
		add(new GLine(p3.getX(), p3.getY(), p2.getX(), p2.getY()));
	}
	
	private void addRightLeg() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		GPoint p1 = new GPoint(xc, yc);
		GPoint p2 = new GPoint(xc + HIP_WIDTH, yc);
		GPoint p3 = new GPoint(xc + HIP_WIDTH, yc + LEG_LENGTH);
		add(new GLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
		add(new GLine(p3.getX(), p3.getY(), p2.getX(), p2.getY()));
	}
	
	private void addLeftFoot() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		add(new GLine(xc - HIP_WIDTH, yc + LEG_LENGTH, xc - HIP_WIDTH - FOOT_LENGTH, yc + LEG_LENGTH));
	}
	
	private void addRightFoot() {
		int xc = getWidth() / 2;
		int yc = getHeight() / 2;
		add(new GLine(xc + HIP_WIDTH, yc + LEG_LENGTH, xc + HIP_WIDTH + FOOT_LENGTH, yc + LEG_LENGTH));
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 370;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	//invas
	private GLabel answerLabel, guessLabel;
	private int numOfGuess;
    private String guess;


}
