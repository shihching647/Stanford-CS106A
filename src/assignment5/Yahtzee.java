package assignment5;/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.IODialog;
import acm.program.GraphicsProgram;
import assignment5.lib.YahtzeeConstants;
import assignment5.lib.YahtzeeDisplay;

import java.util.ArrayList;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static final int BONUS = 35;
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		initial(nPlayers);
		for(int i = 0; i < N_SCORING_CATEGORIES; i++) {
			for(int j = 1; j <= nPlayers; j++) {
				playOneRound(j);
			}
		}
		showResult();
	}
	
	//初始化二維陣列 並將所有element設成-1: scores[0][0]表示 player1的ones分數
	void initial(int nPlayers) {
		scores = new int[nPlayers][N_CATEGORIES];
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				scores[i][j] = -1;
			}
		}
	}
	
	/**
	 * 玩一回合
	 * @param player : player從1開始(因為要配合Yahtzee的方法使用)
	 */
	private void playOneRound(int player) {
		//第一次骰
		display.printMessage("Wait for " + playerNames[player - 1] + " click above to roll the dice."); //player從1開始
		display.waitForPlayerToClickRoll(player);
		rolldice();
		//第二三次骰
		int chance_to_reroll = 2;
		while(chance_to_reroll > 0) {
			display.printMessage("Select the dice you'd like to re-roll.");
			display.waitForPlayerToSelectDice();
			rerolldice();
			chance_to_reroll--;
		}
		updateScore(player);
	}
	//第一次骰全部的骰子
	private void rolldice() {
		for(int i = 0; i < N_DICE; i++) {
			dice[i] = (int)(Math.random() * 6) + 1;
		}
		display.displayDice(dice);
	}
	//第二,三次骰選中的的骰子
	private void rerolldice() {
		for(int i = 0; i < N_DICE; i++) {
			if(display.isDieSelected(i))
				dice[i] = (int)(Math.random() * 6) + 1;
		}
		display.displayDice(dice);
	}
	
	//更新分數
	private void updateScore(int player) {
		int category = 0, score = 0;
		//選到沒有重覆的category為止
		while(true) {
			display.printMessage("Choose a category to assign your dice to.");
			category = display.waitForPlayerToSelectCategory();
			//scores裡面元素如果為-1 -->表示還沒填過值
			if(scores[player - 1][category - 1] == -1) {  //使用display.的方法時所得到的player, cateogey都要減1!
				break;
			}
		}
		//檢驗分數是否符合計分方式,並更新分數到scores陣列
		if(checkCategory(dice, category)) {  //YahtzeeMagicStub.checkCategory(dice, category)
			score = countScore(category);
			display.updateScorecard(category, player, score);
			scores[player - 1][category - 1] = score;
		}else {
			display.updateScorecard(category, player, 0);
			scores[player - 1][category - 1] = 0;
		}
		//檢查上下排是否可以填分數
		countUpperScore(player);
		countLowerScore(player);
	}
	
	//檢查是否符合計分格式
	private boolean checkCategory(int[] dices, int category) {
		ArrayList<Integer> frequency = new ArrayList<Integer> ();
		int[] vaildItem;
		frequency = getFrequency(dices);
		vaildItem = getVaildItem(frequency);
		
		for(int i = 0; i < vaildItem.length; i++) {
			if(category == vaildItem[i])
				return true;
		}
		
		int[] alwaysTrue = {ONES, TWOS, THREES, FOURS, FIVES, SIXES, CHANCE};
		for(int i = 0; i < alwaysTrue.length; i++) {
			if(category == alwaysTrue[i])
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
			int[] result = {FOUR_OF_A_KIND, THREE_OF_A_KIND};
			return result;
		}
		//FULL_HOUSE & THREE_OF_A_KIND
		if(frequency.contains(3)) {
			if(frequency.contains(2)) {
				int[] result = {FULL_HOUSE, THREE_OF_A_KIND};
				return result;
			}else{
				int[] result = {THREE_OF_A_KIND};
				return result;
			}
		}
		//LARGE_STRAIGHT(12345,23456)每個數次剛好出現一次
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
		//SMALL_STRAIGHT(1234, 2345, 3456組合) 只要每一個數字出現次數大於等於1次就可以
		if(frequency.get(1) >= 1 && frequency.get(2) >= 1 &&
				frequency.get(3) >= 1 && frequency.get(4) >= 1) {
			int[] result = {SMALL_STRAIGHT};
			return result;
		}
		
		if(frequency.get(2) >= 1 && frequency.get(3) >= 1 &&
				frequency.get(4) >= 1 && frequency.get(5) >= 1) {
			int[] result = {SMALL_STRAIGHT};
			return result;
		}
		
		if(frequency.get(3) >= 1 && frequency.get(4) >= 1 &&
				frequency.get(5) >= 1 && frequency.get(6) >= 1) {
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

	/**
	 * 計算滿足某種category的分數
	 * @param category 滿足的category
	 * @return 分數
	 */
	private int countScore(int category) {
		switch(category) {
			case ONES: return countN(1);
			case TWOS: return countN(2);
			case THREES: return countN(3);
			case FOURS: return countN(4);
			case FIVES: return countN(5);
			case SIXES: return countN(6);
			case FULL_HOUSE: return 25;
			case SMALL_STRAIGHT: return 30;
			case LARGE_STRAIGHT: return 40;
			case YAHTZEE: return 50;
			default: return countTotal();
		}
	}
	
	//全部骰子的點數和
	private int countTotal() {
		int result = 0;
		for(int i = 0; i < dice.length; i++) {
			result += dice[i];
		}
		return result;
	}
	/**
	 * 計算特定一面n的總和
	 * @param n 骰子的點數
	 * @return 分數
	 */
	private int countN(int n) {
		int result = 0;
		for(int i = 0; i < dice.length; i++) {
			if(dice[i] == n)
				result += n;
		}
		return result;
	}
	
	//計算上排分數
	private void countUpperScore(int player) {
		int sum = 0;
		for(int i = 0; i < 6; i++) {
			if(scores[player - 1][i] == -1) {
				sum = 0;
				break;
			}else
				sum += scores[player - 1][i];
		}
		//Update upper score card
		if(sum != 0) {
			display.updateScorecard(UPPER_SCORE, player, sum);
			scores[player - 1][UPPER_SCORE - 1] = sum;  ////使用display.的方法時所得到的player, cateogey都要減1!
			if(sum >= 67) {
				display.updateScorecard(UPPER_BONUS, player, BONUS);
				scores[player - 1][UPPER_BONUS - 1] = BONUS;
			}else {
				display.updateScorecard(UPPER_BONUS, player, 0);
				scores[player - 1][UPPER_BONUS - 1] = 0;
			}
		}
	}
	
	//計算下排分數
	private void countLowerScore(int player) {
		int sum = 0;
		for(int i = 8; i <= 14; i++) {
			if(scores[player - 1][i] == -1) {
				sum = 0;
				break;
			}else
				sum += scores[player - 1][i];
		}
		//Update lower score card
		if(sum != 0) {
			display.updateScorecard(LOWER_SCORE, player, sum); 
			scores[player - 1][LOWER_SCORE - 1] = sum;
		}
	}
	//計算總分,並秀出贏家
	private void showResult() {
		for(int i = 0; i < nPlayers; i++) {
			int sum = 0;
			int player = i + 1;
			sum = scores[i][6] + scores[i][7] + scores[i][15];
			display.updateScorecard(TOTAL, player, sum);
			scores[i][TOTAL - 1] = sum;
		}
		int winner = 0;
		for(int i = 0; i < nPlayers; i++) {
			if(scores[i][TOTAL - 1] > scores[winner][TOTAL -1])
				winner = i;
		}
		display.printMessage("Congratulations, " + playerNames[winner] + ", you're the winner with a total score of " 
				+ scores[winner][TOTAL - 1]);
	}

		
	
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
//	private RandomGenerator rgen = new RandomGenerator();
	
	private int[] dice = new int[N_DICE];
	private int[][] scores;  //使用二維陣列來紀錄分數,scores[0][0]表示 player1的ones分數,所以當使用display.的方法時所得到的player, cateogey都要減1!
}
