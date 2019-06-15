/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 */
public class NewSortTest {

	@Test
	public void testData1() {
		Integer[] arr = { 2, 4,6,8,9,10, 1, 3,5,7,11,13 };
		NewSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void testData2() {
		Integer[] arr = { 1, 3, 2, 4, };
		NewSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}
	
	@Test
	public void testData3() {
		Integer[] arr = { 1, 2, 3, 4, };
		NewSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}
	
	@Test
	public void testData4() {
		Integer[] arr = { 1, 4, 2, 3,};
		NewSort.sort(arr);
		assertEquals(true, isSorted(arr));
	}
	
	@Test
	public void testData5() {
		Integer[] arr = { 2, 4,1, 3,};
		NewSort.sort(arr);
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
