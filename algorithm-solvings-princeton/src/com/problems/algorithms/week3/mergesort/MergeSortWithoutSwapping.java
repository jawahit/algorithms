/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

/**
 * Merge sort implementation
 * 
 * Compares Performance
 * 
 * worst ,average & best complexity : O(nlogn) Space complexity: n
 * 
 * Assuming if N is power of 2 then total performance is NlogN
 * 
 * for Ex: if N = 4 then totally it will take 4 * logbase2(4) = 8 iteration to
 * sort it
 * 
 * for Ex: if N = 16 then totally it will take 16 * logbase2(16) = 64 iteration
 * to sort it
 * 
 * And Array Access id 6NlgN for any size of array
 * 
 * @author Thangaraj Jawahar
 *
 */
public class MergeSortWithoutSwapping {

	static int count = 0;

	public static void sort(Object[] c) {
		Object[] dest = new Object[c.length];
		divideAndConquer(c, dest, 0, c.length - 1);
	}

	private static void divideAndConquer(Object[] src, Object[] dest, int start, int end) {
		if (start == end) {
			return;
		}
		int mid = (start + end) >>> 1;
		divideAndConquer(src, dest, start, mid);
		divideAndConquer(src, dest, mid + 1, end);
		merge(src, dest, start, mid + 1, end);
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
		copyArray(src, dest, start, end);
		// if it's already sorted just return copy the source to
		if (((Comparable) src[mid]).compareTo(src[mid - 1]) >= 0) {
			return;
		}
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

	private static void copyArray(Object[] src, Object[] dest, int start, int end) {
		for (int i = start; i <= end; i++) {
			dest[i] = src[i];
		}
	}

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
		System.out.println("Un Sorted: ");
		String[] unsorted = { "zebra", "apple", "orange", "mango", "zebra", "apple", "orange", "mango" };
		for (String i : unsorted) {
			System.out.print(i + " ");
		}
		sort(unsorted);
		System.out.println();
		System.out.println("Sorted: ");
		for (String i : unsorted) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Total Iteration Count to Sort:" + count);
	}

}
