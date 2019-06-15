/**
 * 
 */
package com.problems.algorithms.week1.analysis.of.algorithms;

/**
 * this class {@code SearchInBitonicArray} search element in Bitonic Array
 * (increasing sequence followed by decreasing sequence of integers)
 * 
 * @author Thangaraj Jawahar
 * 
 *         O(N) = 3logN (worst case)
 * 
 *         how 3logN > logN for find bitonic point >logN for search left side
 *         >logN for search right side
 *
 */
public class SearchInBitonicArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] bitonicArray = { 1, 3, 5, 7, 9, 10, 12, 11, 4, 2 };
		// int[] bitonicArray = { 1, 3, 5, 7, 9, 10, 12, 14, 15, 16 };
		int[] bitonicArray = { 1, 12, 13, 14, 15, 16, 17, 18, 19, 10, 7, 5, 2 };
		int searchKey = 2;
		searchElementInBitonicArray(bitonicArray, searchKey);
	}

	/**
	 * @param bitonicArray
	 * @param searchKey
	 */
	private static void searchElementInBitonicArray(int[] bitonicArray, int searchKey) {
		int bitonicPointIndex = findBitonicPoint(bitonicArray);
		if (bitonicPointIndex == -1) {
			System.out.println("its not an bitonic Array");
			return;
		}
		int bitonicValue = bitonicArray[bitonicPointIndex];
		if (searchKey == bitonicValue) {
			System.out.println("Search Element Found !!! and index in the array is " + bitonicPointIndex);
		} else if (searchKey > bitonicValue) {
			System.out.println("Search Element is not found on Bitonic Array Sorry :(");
		} else {
			int indexFound = BinarySearch.binarySearchRecursive(bitonicArray, 0, bitonicPointIndex - 1, searchKey,
					bitonicPointIndex);
			if (indexFound == -1) {
				indexFound = BinarySearch.binarySearchReverseRecursive(bitonicArray, bitonicPointIndex + 1,
						bitonicArray.length - 1, searchKey, bitonicArray.length - 1);
			}
			System.out.println("Search Element Found !!! and index in the bitonic array is " + indexFound);
		}
	}

	/**
	 * find the bitonic point of the given Array
	 * 
	 * @param a
	 * @return
	 */
	public static int findBitonicPoint(int[] a) {

		int lo = 0;
		int hi = a.length - 1;
		int count = 0;
		while (lo <= hi) {
			count++;
			int mid = (lo + hi) / 2;
			int midValue = a[mid];
			int midRightValue = mid + 1;
			int midLeftValue = mid - 1;
			if (midRightValue > (a.length - 1) || midLeftValue < 0)
				return -1;
			if (midValue > a[midRightValue] && a[midLeftValue] < midValue) {
				System.out.println("looping Count : " + count);
				return mid;
			} else if (a[midRightValue] > midValue) {
				lo = midRightValue;
			} else {
				hi = midLeftValue;
			}

		}
		return -1;
	}

}
