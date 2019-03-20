/**
 * 
 */
package com.problems.algorithms.week2.sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Thangaraj Jawahar
 *
 */
public class Shuffling {
	
	public static void main(String args[]) {
		String[] flightNames = { "aa", "aab", "m" , "z" , "k"};
		sort(flightNames);
		for(String s: flightNames) {
			System.out.print(s+ " ");
		}
		
	}
	
	public static void sort(Comparable[] c) {
		if(c == null || c.length == 0) {
			throw new IllegalArgumentException("Shoudn't be null");
		}
		for(int i = 0 ; i < c.length; i++) {
			int r = StdRandom.uniform(i + 1);
			SortingUtils.exchange(c, i, r);
		}
	}

}
