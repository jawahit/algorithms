/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import com.problems.algorithms.week3.quicksort.QuickSort;

/**
 * @author Thangaraj Jawahar
 *
 */
public class QuickSelect {

	public static Comparable findKthSmallest(Comparable[] a, int k) {
		int low = 0, high = a.length - 1;
		if (k > high)
			throw new IllegalArgumentException("k is out of range");
		while (high > low) {
			int j = QuickSort.partioning(a, low, high);
			if (j > k)
				high = j - 1;
			else if (j < k)
				low = j + 1;
			else
				return a[k];
		}
		return a[k];
	}

	public static Comparable findKthLargest(Comparable[] a, int k) {
		int high = (a.length - 1);
		if (k > high || k < 0)
			throw new IllegalArgumentException("k is out of range");
		k = (a.length - 1) - k;
		return findKthSmallest(a, k);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
				"E" };
		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		// A C E E G I I K L M N O P Q Q R S T U X
		System.out.println(findKthSmallest(arr, 10));
		System.out.println(findKthLargest(arr, 1));
	}

}
