/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

import java.util.Comparator;

/**
 * Merge sort implementation
 * 
 * Compares Performance
 * 
 * Time Complexity:
 * 		worst ,average & best complexity: O(Nlogn)
 * Space complexity: O(N)
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
 * Features: 
 *    Stable sort and guaranteed NlogN performance
 *    
 * Disadvantage:
 * 
 *    Extra Aux space O(N) that's used for sort the objects
 * 
 * @author Thangaraj Jawahar
 *
 */
public class MergeSort {

	static int count = 0;

	public static void sort(Object[] c,Comparator comp) {
		Object[] dest = new Object[c.length];
		copyArray(c, dest, 0, c.length -1);
		if(comp ==null) {
			divideAndConquer(dest, c, 0, c.length - 1);			
		} else {
			divideAndConquerWithComparator(dest, c, 0, c.length - 1, comp);
		}
//		for (Object i : c) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}
	
	private static void divideAndConquerWithComparator(Object[] src, Object[] dest, int start, int end, Comparator comp) {
		if (start == end) {
			return;
		}
		int mid = (start + end) >>> 1;
		// mind twisting part :) thanks to Robert Sedgewick for saving array copy time 
		divideAndConquerWithComparator(dest, src, start, mid,comp);
		divideAndConquerWithComparator(dest, src, mid + 1, end,comp);
		merge(src, dest, start, mid + 1, end, comp);
	}
	
	private static void merge(Object[] src, Object[] dest, int start, int mid, int end,Comparator comp) {
		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			count++;
			if (startPoint >= mid
					|| (midPoint <= end && comp.compare(src[startPoint],(src[midPoint])) > 0)) {
				dest[destIndex] = src[midPoint++];
			} else {
				dest[destIndex] = src[startPoint++];
			}
		}
	}

	private static void divideAndConquer(Object[] src, Object[] dest, int start, int end) {
		if (start == end) {
			return;
		}
		int mid = (start + end) >>> 1;
		// mind twisting part :) thanks to Robert Sedgewick for saving array copy time 
		divideAndConquer(dest, src, start, mid);
		divideAndConquer(dest, src, mid + 1, end);
		merge(src, dest, start, mid + 1, end);
	}

	private static void merge(Object[] src, Object[] dest, int start, int mid, int end) {
		for (int startPoint = start, midPoint = mid, destIndex = startPoint; destIndex <= end; destIndex++) {
			count++;
			if (startPoint >= mid
					|| (midPoint <= end && ((Comparable) src[startPoint]).compareTo(src[midPoint]) > 0)) {
				dest[destIndex] = src[midPoint++];
			} else {
				dest[destIndex] = src[startPoint++];
			}
		}
	}

	/**
	 * copy src to dest
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

	/**
	 * to undestand the divide & conquer and state of the variables
	 * better
	 * 
	 * @param start
	 * @param end
	 */
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
		sort(unsorted, null);
		System.out.println();
		System.out.println("Sorted: ");
		for (String i : unsorted) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Total Iteration Count to Sort:" + count);
		recursivePrint(0, 5);
	}

}
