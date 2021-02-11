package assignment5;

import acm.program.ConsoleProgram;

import java.util.ArrayList;

public class Test extends ConsoleProgram {

	public void run(){
		for(int i = 0; i < 1000; i++) {
			rolldice();
			if(checkCategory(dice, SMALL_STRAIGHT)) {
				printDice();
			}
		}
	}
	
	private void rolldice() {
		for(int i = 0; i < 5; i++) {
			dice[i] = (int)(Math.random() * 6) + 1;
		}
	}
	
	private void printDice() {
		for(int i = 0; i < 5; i++) {
			print(dice[i] + "\t");
		}
		println();
	}
	
	private boolean checkCategory(int[] dices, int category) {
		ArrayList<Integer> frequency = new ArrayList<Integer> ();
		int[] vaildItem;
		frequency = getFrequency(dices);
		vaildItem = getVaildItem(frequency);
		for(int i = 0; i < vaildItem.length; i++) {
			if(category == vaildItem[i])
				return true;
		}
		return false;
	}

	private int[] getVaildItem(ArrayList<Integer> frequency) {
		//YAHTZEE
		if(frequency.contains(5)) {
			int[] result = {YAHTZEE, FULL_HOUSE, FOUR_OF_A_KIND, THREE_OF_A_KIND};
			return result;
		}
		//FOUR_OF_A_KIND
		if(frequency.contains(4)) {
			int[] result = {FOUR_OF_A_KIND};
			return result;
		}
		//FULL_HOUSE & THREE_OF_A_KIND
		if(frequency.contains(3)) {
			if(frequency.contains(2)) {
				int[] result = {FULL_HOUSE};
				return result;
			}else{
				int[] result = {THREE_OF_A_KIND};
				return result;
			}
		}
		//LARGE_STRAIGHT
		if(frequency.get(1) == 1 && frequency.get(2) == 1 && frequency.get(3) == 1 &&
				frequency.get(4) == 1 && frequency.get(5) == 1) {
			int[] result = {LARGE_STRAIGHT, SMALL_STRAIGHT};
			return result;
		}
		
		if(frequency.get(6) == 1 && frequency.get(2) == 1 && frequency.get(3) == 1 &&
				frequency.get(4) == 1 && frequency.get(5) == 1) {
			int[] result = {LARGE_STRAIGHT, SMALL_STRAIGHT};
			return result;
		}
		//SMALL_STRAIGHT
		if(frequency.get(2) >= 1 && frequency.get(3) >= 1 &&
				frequency.get(4) >= 1 && frequency.get(5) >= 1) {
			int[] result = {SMALL_STRAIGHT};
			return result;
		}
		
		if(frequency.get(2) >= 1 && frequency.get(3) >= 1 &&
				frequency.get(4) >= 1 && frequency.get(5) >= 1) {
			int[] result = {SMALL_STRAIGHT};
			return result;
		}
		
		if(frequency.get(2) >= 1 && frequency.get(3) >= 1 &&
				frequency.get(4) >= 1 && frequency.get(5) >= 1) {
			int[] result = {SMALL_STRAIGHT};
			return result;
		}
		
		int[] result = {-1};
		return result;
	}

	private ArrayList<Integer> getFrequency(int[] dices) {
		ArrayList<Integer> frequency = new ArrayList<Integer>();
		//initial
		for(int i = 0; i < 7; i++) {
			frequency.add(i, 0);
		}
		//set
		for(int i = 0; i < dices.length; i++) {
			frequency.set(dices[i], frequency.get(dices[i]) + 1);
		}
		return frequency;
	}

	private int[] dice = new int[5];
	public static final int ONES = 1;
	public static final int TWOS = 2;
	public static final int THREES = 3;
	public static final int FOURS = 4;
	public static final int FIVES = 5;
	public static final int SIXES = 6;
	public static final int UPPER_SCORE = 7;
	public static final int UPPER_BONUS = 8;
	public static final int THREE_OF_A_KIND = 9;
	public static final int FOUR_OF_A_KIND = 10;
	public static final int FULL_HOUSE = 11;
	public static final int SMALL_STRAIGHT = 12;
	public static final int LARGE_STRAIGHT = 13;
	public static final int YAHTZEE = 14;
	public static final int CHANCE = 15;
	public static final int LOWER_SCORE = 16;
	public static final int TOTAL = 17;
}
