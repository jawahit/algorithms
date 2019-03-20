/**
 * 
 */
package com.problems.algorithms.week2.sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * This class {@code InsertionSort} is well known approach if the array is already sorted
 * 
 *  performance
 *     ~ n^2 / 2 for avg & worst
 *     O(N) = n^2 for avg & worst
 *     N - For Best
 * @author Thangaraj Jawahar
 *
 */
public class InsertionSort {
	
	public static void sort(Comparable[] c) {
		int count = 0;
		for(int i = 0; i < c.length; i++) {
			int j = i;
			count++;
			while(j > 0) {
				if(c[j].compareTo(c[j-1]) < 0) {
					SortingUtils.exchange(c, j, j-1);
				}
				j--;
				count++;
			}
		}
		System.out.println("loop count" + count);
	}
	


}
