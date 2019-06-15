/**
 * 
 */
package com.problems.algorithms.week1.analysis.of.algorithms;

/**
 * This class {@code EggDrop} is used to find the floor where egg will start
 * breaking
 * 
 * @author Thangaraj Jawahar
 * 
 *         No Of Eggs ~1logN No of Toss ~1logN (No of tries)
 *
 */
public class EggDrop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// No Of floors
		int T = 10;
		int[] floors = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// For Example egg will get break if we drop from 8th floor, 9th floor and so on
		// for sure
		// so till 7th floors egg will not break
		int eggBreakFloor = 8;
		System.out.println(findEggBreakFloor(floors, eggBreakFloor));

	}

	public static int findEggBreakFloor(int[] floors, int eggBreakFloor) {
		int floorIndex = BinarySearch.binarySearch(floors, eggBreakFloor);
		return floorIndex;
	}

}
