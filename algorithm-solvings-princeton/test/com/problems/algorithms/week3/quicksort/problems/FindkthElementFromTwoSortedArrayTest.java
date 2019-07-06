package com.problems.algorithms.week3.quicksort.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindkthElementFromTwoSortedArrayTest {
	
	@Test
	public void randomTest() {
		Integer[] arr1 = { 2, 3, 6, 7, 9 };
		Integer[] arr2 = { 10, 40, 80, 100 };
		int k = 2;
		Comparable a = FindKthElementFromTwoSortedArray.findK(arr1, arr1.length, arr2, arr2.length, k);
		assertEquals(3, a);
	}
	
	@Test
	public void randomTest1() {
		Integer[] arr1 = { 2, 3, 6, 7, 9 };
		Integer[] arr2 = { 10, 40, 80, 100 };
		int k = 5;
		Comparable a = FindKthElementFromTwoSortedArray.findK(arr1, arr1.length, arr2, arr2.length, k);
		assertEquals(9, a);
	}

	@Test
	public void randomTest2() {
		Integer[] arr1 = { 2, 3, 6, 7, 9 };
		Integer[] arr2 = { 10, 40, 80, 100 };
		int k = 6;
		Comparable a = FindKthElementFromTwoSortedArray.findK(arr1, arr1.length, arr2, arr2.length, k);
		assertEquals(10, a);
	}
	
	@Test
	public void randomTest3() {
		Integer[] arr1 = { 2, 3, 6, 7, 9 };
		Integer[] arr2 = { 10, 40, 80, 100 };
		int k = 8;
		Comparable a = FindKthElementFromTwoSortedArray.findK(arr1, arr1.length, arr2, arr2.length, k);
		assertEquals(80, a);
	}
	
	@Test
	public void randomTest4() {
		Integer[] arr1 = { 1,2,3,4,5};
		Integer[] arr2 = { 1,2,3,4,5 };
		int k = 3;
		Comparable a = FindKthElementFromTwoSortedArray.findK(arr1, arr1.length, arr2, arr2.length, k);
		assertEquals(2, a);
	}
	
	@Test
	public void randomTest5() {
		Integer[] arr1 = { 1,2,3,4,5};
		Integer[] arr2 = { 1,2,3,4,5 };
		int k = 5;
		Comparable a = FindKthElementFromTwoSortedArray.findK(arr1, arr1.length, arr2, arr2.length, k);
		assertEquals(3, a);
	}
}
