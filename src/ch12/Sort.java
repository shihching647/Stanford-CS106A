package ch12;

import acm.program.*;

public class Sort extends ConsoleProgram{
	
	public void run() {
		int[] array = {1, 34, 34, 45, 9, 40, 27, 13};
//		selectionSort(array);
		insertionSort(array);
		printArray(array);
	}

	private void printArray(int[] array) {
		print("array = [");
		for(int i = 0; i < array.length; i++) {
			print(i != array.length - 1 ? (array[i] + ", ") : (array[i] + "]"));
		}
		
	}
	
	//selection sort
	private void selectionSort(int[] array) {
		for(int lh = 0; lh < array.length; lh++) {
			int rh = findSmallest(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}
	
	private int findSmallest(int[] array, int p1, int p2) {
		int smallestIndex = p1;
		for(int i = p1 + 1; i < p2; i++) {
			if(array[i] < array[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}
	
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	
	//insertion sort
	private void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int j = i - 1;
			int key = array[i];
			while(key < array[j] && j > -1) { //比當下那一個大且有前一個
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}
}
