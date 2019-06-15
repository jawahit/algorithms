/**
 * 
 */
package com.problems.algorithms.week1.analysis.of.algorithms;

/**
 * this class {@code BinarySearch} contains binary search algorithm using
 * recursive & iterative method O(N) = 1+ logN
 * 
 * @author Thangaraj Jawahar
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { -40, -20, -10, 0, 2, 10, 30, 40 };
		System.out.println(binarySearch(a, -20));
		System.out.println(binarySearchRecursive(a, 0, a.length - 2, 50, a.length - 2));
		int[] descArray = { 40, 30, 10, 2, 0, -10, -20, -40 };
		System.out.println(binarySearchReverseRecursive(descArray, 0, descArray.length - 1, -40, descArray.length - 1));

	}

	public static int binarySearch(int[] a, int key) {
		int count = 0;
		int size = a.length;
		if (size < 0) {
			return -1;
		}
		int lo = 0, hi = a.length - 1;
		while (lo <= hi) {
			count++;
			int mid = (hi + lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else {
				System.out.println("Loop Rotation Count : " + count);
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] arr, int start, int end, int key, int size) {
		int mid = (start + end) / 2;
		int midValue = arr[mid];
		if (midValue == key) {
			return mid;
		} else if (key < midValue) {
			if ((mid - 1) < 0)
				return -1;
			return binarySearchRecursive(arr, start, mid - 1, key, size);
		} else {
			if ((mid + 1) > size || mid == 0)
				return -1;
			return binarySearchRecursive(arr, mid + 1, end, key, size);
		}
	}

	public static int binarySearchReverseRecursive(int[] arr, int start, int end, int key, int size) {
		int mid = (start + end) / 2;
		int midValue = arr[mid];
		if (midValue == key) {
			return mid;
		} else if (key < midValue) {
			if ((mid + 1) > size)
				return -1;
			return binarySearchReverseRecursive(arr, mid + 1, end, key, size);
		} else {
			if ((mid - 1) < 0)
				return -1;
			return binarySearchReverseRecursive(arr, start, mid - 1, key, size);
		}
	}

}
