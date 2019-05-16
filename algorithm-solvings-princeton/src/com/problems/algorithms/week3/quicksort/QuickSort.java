/**
 * 
 */
package com.problems.algorithms.week3.quicksort;

import java.util.Comparator;

import com.problems.algorithms.week2.sorting.Shuffling;
import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * @author Thangaraj Jawahar
 *
 */
public class QuickSort {

	public static void sort(Object[] c, Comparator comp) {
		if (comp == null) {
			Shuffling.sort((Comparable[]) c);
			System.out.print("Input: ");
			print(c);
			sort(c, 0, c.length - 1);
			System.out.print("Output: ");
			print(c);
		}
	}

	public static void sort(Object[] c, int start, int end) {
		if (end <= start)
			return;
		int j = partioning(c, start, end);
		sort(c, start, j - 1);
		sort(c, j + 1, end);
	}

	public static int partioning(Object[] c, int i, int j) {
		int lowIndex = i;
		int end = j;
		while (true) {
			while (i <= end && ((Comparable) c[i]).compareTo(c[lowIndex]) <= 0) {
				i++;
			}
			while (j >= i && ((Comparable) c[j]).compareTo(c[lowIndex]) > 0) {
				j--;
			}
			if (j > i) {
				SortingUtils.exchange((Comparable[]) c, i, j);
			} else {
				break;
			}
		}
		SortingUtils.exchange((Comparable[]) c, j, lowIndex);
		return j;
	}

	public static int partioning(Object[] c, Object low, int i, int j) {
		while (((Comparable) c[i]).compareTo(low) < 0) {
			i++;
		}
		while (((Comparable) c[j]).compareTo(low) > 0) {
			j--;
		}
		if (i < j && j > i) {
			SortingUtils.exchange((Comparable[]) c, i, j);
			return partioning(c, low, i, j);
		} else {
			SortingUtils.exchange((Comparable[]) c, j, 0);
			return j;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = { "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
				"E" };
		for (int i = 0; i < 200; i++) {
			sort(arr, null);
		}

	}

	public static void print(Object[] arr) {
		for (Object s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

}
