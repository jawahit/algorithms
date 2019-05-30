/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 */
public class FindKthLargestTest {
	
	
	@Test
	public void testAllAscending() {

		Comparable[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		QuickSelect q = new QuickSelect();
		Assert.assertEquals(10, q.findKthLargest(arr, 0));

	}

	@Test
	public void testAllDEscending() {

		Comparable[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		QuickSelect q = new QuickSelect();
		Assert.assertEquals(10, q.findKthLargest(arr, 0));

	}

	@Test
	public void testRandom() {

		Comparable[] arr = { 5, 6, 7, 8, 8, 98, 9, 9, 5, 4, 3, 2, 1 };
		QuickSelect q = new QuickSelect();
		Assert.assertEquals(98, q.findKthLargest(arr, 0));

	}

	@Test
	public void testRandomMid() {

		Comparable[] arr = { 5, 6, 7, 8, 8, 98, 9, 9, 5, 4, 3, 2, 1 };
		QuickSelect q = new QuickSelect();
		Assert.assertEquals(7, q.findKthLargest(arr, 5));

	}

	@Test
	public void testRandomLast() {

		Comparable[] arr = { 5, 6, 7, 8, 8, 98, 9, 9, 5, 4, 3, 2, 1 };
		QuickSelect q = new QuickSelect();
		Assert.assertEquals(1, q.findKthLargest(arr, 12));

	}

}
