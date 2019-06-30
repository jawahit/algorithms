/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import java.util.Random;

import com.problems.algorithms.week2.sorting.SortingUtils;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * This class {@code NutsAndBoltsProblem} is based on Quicksort implementation
 * worst case performance is O(nLogn)
 * 
 * 
 * @author Thangaraj Jawahar
 *
 *         Jun 23, 2019
 * 
 *
 */
public class NutsAndBoltsProblem {

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nuts = { 12, 11, 2, 4, 3, 5, 10, 9, 8, 7, 6, 1 };
		Integer[] bolts = { 5, 4, 3, 2, 1, 9, 8, 10, 6, 7, 11, 12 };
		matchPair(nuts, bolts, 0, nuts.length - 1);
		SortingUtils.print(nuts);
		SortingUtils.print(bolts);
	}

	public static void findPairs(Comparable[] a, Comparable[] b) {
		matchPair(a, b, 0, a.length - 1);
		SortingUtils.print(a);
		SortingUtils.print(b);
	}

	public static void matchPair(Comparable[] a, Comparable[] b, int start, int end) {
		if (end <= start)
			return;
		Comparable random = a[StdRandom.uniform(start, end + 1)];
		int pivotIndex = partition(b, start, end, random);
		partition(a, start, end, b[pivotIndex]);
		matchPair(a, b, start, pivotIndex - 1);
		matchPair(a, b, pivotIndex + 1, end);
	}

	/**
	 * the main idea behind this method is moving the matched pivot element to the
	 * last index (at the time we see the pivot element) and sort the lower elements
	 * to the left and always the keep the pointer on the higher element when the
	 * loops ends just switch the last index (pivot element ) with the higher
	 * starting point index we kept
	 *
	 * @param dest
	 * @param start
	 * @param end
	 * @param pivot
	 * @return
	 */
	public static int partition(Comparable[] dest, int start, int end, Comparable pivot) {
		int i = start;
		for (int j = start; j < end; j++) {
			if (dest[j].compareTo(pivot) < 0) {
				SortingUtils.exchange(dest, i++, j);
			} else if (dest[j].compareTo(pivot) == 0) {
				SortingUtils.exchange(dest, j--, end);
			}
		}
		SortingUtils.exchange(dest, end, i);
		return i;
	}

}
