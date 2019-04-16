/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test Class for {@code MergeSort}
 * 
 * @author Thangaraj Jawahar
 *
 */
public class MergeSortTest {

	@Test
	public void checkForLengthLessThan5() {
		Integer[] arr = { 5, 4, 1, 2, 6 };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void alreadySorted() {
		Integer[] arr = { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3 };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForLongerValues() {
		Integer[] arr = { 4, 5, 1, 2, 6, 8, 2, 1, 3, 4, 5, 6, 9, 11, 2, 7, 2, 5, 56, -1, -3, 3, 1, 98 };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForStringValues() {
		String[] arr = { "zebra", "apple", "orange", "mango", "coconut", "gauva" };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForAlphabetValues() {
		String[] arr = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
				"E" };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForFullyDescendingOrderValues() {
		Integer[] arr = { 100, 99, 1, 2, 98, 97, 96, 50, 45, 34, 23, 12, 2, 1 };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForLongerStringWithNumber() {
		String[] arr = { "31415926535897932384626433832795", "1", "3", "10", "3", "5" };
		MergeSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	private boolean isSorted(Object[] arr) {
		boolean sorted = true;
		for (int i = 1; i < arr.length; i++) {
			if (((Comparable) (arr[i - 1])).compareTo(arr[i]) > 0) {
				sorted = false;
				break;
			}
		}
		return sorted;
	}

}
