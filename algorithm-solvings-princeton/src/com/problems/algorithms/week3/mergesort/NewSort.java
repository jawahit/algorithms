/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

/**
 * @author Thangaraj Jawahar
 *
 */
public class NewSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = { 1, 3, 2, 4 };
		sort(a);
		for (Integer i : a) {
			System.out.print(i + " ");
		}
	}

	public static void sort(Object[] src) {
		merge(src, 0, src.length >>> 1, src.length - 1);
	}

	private static void merge(Object[] src, int start, int mid, int end) {
		Object temp = src[start];
		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			if (startPoint >= mid || (midPoint <= end && ((Comparable) temp).compareTo(src[midPoint]) > 0)) {
				if (src[destIndex] != null) {
					temp = src[destIndex];
				}
				if (midPoint > end) {
					src[destIndex] = temp;
				} else {
					src[destIndex] = src[midPoint];
					if (midPoint < end) {
						src[midPoint] = null;						
					}
					midPoint++;
				}
			} else {
				if (src[destIndex] == temp) {
					temp = src[destIndex + 1];
				} else {
					Object tempBk = temp;
					if (src[destIndex] != null) {
						temp = src[destIndex];
					}
					src[destIndex] = tempBk;
				}
				startPoint++;
			}
		}
	}

}
