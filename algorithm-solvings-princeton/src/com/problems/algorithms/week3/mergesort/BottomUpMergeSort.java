/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

/**
 * {@code BottomUpMergeSort} is implementation of merge sort without recursion
 * 
 * @author Thangaraj Jawahar
 *
 */
public class BottomUpMergeSort {

	static int count;

	static Object[] dest = null;

	public static void main(String args[]) {
		String[] unsorted = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		// Integer[] arr = { 5, 4, 1, 2 };
		sort(unsorted);
		System.out.println();
		System.out.println("Sorted: ");
	}

	public static void sort(Object[] c) {
		dest = new Object[c.length];
		for (int i = 1; i <= c.length -1; i = i * 2) {
			for (int j = 0, k = (i * 2) - 1; j <= c.length - 1;) {
				int end = j + k;
				int mid = (j + end) >>> 1;
				merge(c, j, mid + 1, (end > c.length - 1 ? c.length - 1 : end));
				j = end + 1;
			}
		}
		for (Object i : c) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	private static void merge(Object[] src, int start, int mid, int end) {
		copyArray(src, dest, start, end);

		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			count++;
			if (startPoint >= mid
					|| (midPoint <= end && ((Comparable) dest[startPoint]).compareTo(dest[midPoint]) > 0)) {
				src[destIndex] = dest[midPoint++];
			} else {
				src[destIndex] = dest[startPoint++];
			}
		}
	}

	/**
	 * copy src to dest
	 * 
	 * @param src
	 * @param dest
	 * @param start
	 * @param end
	 */
	private static void copyArray(Object[] src, Object[] dest, int start, int end) {
		for (int i = start; i <= end; i++) {
			dest[i] = src[i];
		}
	}

}
