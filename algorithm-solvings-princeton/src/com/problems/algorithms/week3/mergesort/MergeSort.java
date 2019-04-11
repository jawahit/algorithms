/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

/**
 * Merge sort implementation
 * 
 * worst ,average & best complexity : O(nlogn)
 * Space complexity: n
 * 
 * @author Thangaraj Jawahar
 *
 */
public class MergeSort {

	public static void sort(Object[] c) {
		Object[] dest = new Object[c.length];
		divideAndConquer(c, dest, 0, c.length - 1);
	}

	private static void divideAndConquer(Object[] src, Object[] dest, int start, int end) {
		int mid = (start + end) >>> 1;
		if (start == end) {
			return;
		}
		divideAndConquer(src, dest, start, mid);
		divideAndConquer(src, dest, mid + 1, end);
		if (start == mid) {
			swap(src, start, end);
		} else {
			merge(src, dest, start, mid + 1, end);
		}
	}

	private static void swap(Object[] src, int start, int end) {
		Object temp = null;
		if (((Comparable) src[start]).compareTo(src[end]) > 0) {
			temp = src[start];
			src[start] = src[end];
			src[end] = temp;
		}
	}

	private static void merge(Object[] src, Object[] dest, int start, int mid, int end) {
		// copy src to dest
		System.arraycopy(src, 0, dest, 0, src.length);
		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			if (startPoint >= mid
					|| (midPoint <= end && ((Comparable) dest[startPoint]).compareTo(dest[midPoint]) > 0)) {
				src[destIndex] = dest[midPoint++];
			} else {
				src[destIndex] = dest[startPoint++];
			}
		}
	}

	// if it's already sorted just return copy the source to
//			if (((Comparable) src[mid]).compareTo(src[mid - 1]) >= 0) {
//				System.arraycopy(src, start, dest, start, src.length);
//				return;
//			}

	public static void recursivePrint(int start, int end) {
		int mid = (start + end) / 2;
		if (start == end) {
			return;
		}
		recursivePrint(start, mid);
		recursivePrint(mid + 1, end);
		System.out.println("start: " + start + " mid: " + mid + " end: " + end);
	}

	public static void main(String[] args) {

		int start = 4;
		int end = 4;
		int sum = start + end;
//		System.out.println(sum >>> 1);
//		System.out.println(sum/2);
//		recursivePrint(0, 4);
		// Integer[] unsorted = { 4, 5, 1, 2, 6, 8, 2, 3, 4, 5, 6, 9, 11, 2, 7, 2, 5,
		// 56, -1, -3, 3, 1, 98 };
//		String[] unsorted = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
//				"E" };
		// String[] unsorted = { "31415926535897932384626433832795", "1", "3", "10",
		// "3", "5"};
		String[] unsorted = { "zebra", "apple", "orange", "mango", "coconut", "gauva" };
		System.out.println(unsorted);
		sort(unsorted);
		System.out.println(unsorted);
		for (String i : unsorted) {
			System.out.print(i + " ");
		}

		System.out.println("1".compareTo("4"));
	}

}
