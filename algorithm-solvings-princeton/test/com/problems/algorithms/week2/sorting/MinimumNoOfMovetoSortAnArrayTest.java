/**
 * 
 */
package com.problems.algorithms.week2.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 * Jun 22, 2019
 * 
 *
 */
public class MinimumNoOfMovetoSortAnArrayTest {
	
	@Test
	public void test1() {
		int[] arr = {6,1,2,3,7,8,9};
		assertEquals(4,MinimumNoOfMovetoSortAnArray.findNumberOfMoves(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {8,6,1,7,5,2,3,9};
		assertEquals(5,MinimumNoOfMovetoSortAnArray.findNumberOfMoves(arr));
	}
	
	@Test
	public void test3() {
		int[] arr = {5,3,1,2};
		assertEquals(2,MinimumNoOfMovetoSortAnArray.findNumberOfMoves(arr));
	}
	
	@Test
	public void descending() {
		int[] arr = {5,3,2,1};
		assertEquals(3,MinimumNoOfMovetoSortAnArray.findNumberOfMoves(arr));
	}
	
	@Test
	public void ascending() {
		int[] arr = {1,2,3,4};
		assertEquals(0,MinimumNoOfMovetoSortAnArray.findNumberOfMoves(arr));
	}
	

}
