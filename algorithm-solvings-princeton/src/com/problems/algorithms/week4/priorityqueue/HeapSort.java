/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * 
 * This class {@code HeapSort} is the best inplace sorrting algorithm
 *
 * Simple Steps:
 *   1. Build the Max Heap out of Array
 *   2. Delete the Max value from heap and repeatedly maintain the Heap Properties
 *   
 *    Binary Balanced Heap properties:
 *       Parent element is always bigger than the child.
 * 
 * @author Thangaraj Jawahar
 *
 *         Jul 12, 2019
 * 
 *
 */
public class HeapSort<Key extends Comparable<Key>> {

	public static void sort(Comparable[] arr) {
		buildHeap(arr);
		delmaxAndSort(arr);
	}

	
	/**
	 *
	 * delete the max from the heap and maintain the binary heap properties
	 *void
	 * @param arr
	 */
	public static void delmaxAndSort(Comparable[] arr) {
		int k = arr.length - 1;
		for (; k >= 1; k--) {
			delMax(arr, k);
		}
	}

	public static void delMax(Comparable[] arr, int k) {
		SortingUtils.exchange(arr, k, 1);
		sink(arr, 1, k - 1);
	}

	/**
	 * build the max heap
	 *
	 *void
	 * @param arr
	 */
	private static void buildHeap(Comparable[] arr) {
		int k = (arr.length - 1) / 2;
		for (; k >= 1; k--) {
			sink(arr, k, arr.length - 1);
		}
	}

	private static void sink(Comparable[] arr, int k, int N) {
		while (2 * k <= N) {
			int bigger = 2 * k;
			if (bigger < N && SortingUtils.isLess(arr, bigger, bigger + 1))
				bigger++;
			if (SortingUtils.isLess(arr, k, bigger)) {
				SortingUtils.exchange(arr, k, bigger);
			} else
				break;
			k = bigger;
		}
	}

	public static void main(String args[]) {
		// String[] arr = { null, "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E",
		// "Z", "W", "C", "C","Q","R","B" ,"F","Z","D"};
		String[] arr = { null, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "Z", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		sort(arr);
		SortingUtils.print(arr);
	}

}
