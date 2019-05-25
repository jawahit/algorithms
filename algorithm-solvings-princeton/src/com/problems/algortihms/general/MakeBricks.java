/**
 * 
 */
package com.problems.algortihms.general;

/**
 * @author Thangaraj Jawahar
 *
 */
public class MakeBricks {

	public static boolean makeBricks(int small, int big, int goal) {
		if (goal > (big * 5 + small))
			return false;
		if (goal % 5 > small)
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeBricks(20, 2, 21));
	}

}
