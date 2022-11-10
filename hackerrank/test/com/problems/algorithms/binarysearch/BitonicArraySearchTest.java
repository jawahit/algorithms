/**
 * 
 */
package com.problems.algorithms.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;




/**
 * @author Thangaraj Jawahar
 *
 * Mar 25, 2022
 * 
 *
 */
public class BitonicArraySearchTest {

	@Test
	public void bitonicArray() {
		int[] arr = {10,19,20,25,26,1,0,-1};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(4, mid);
	}
	
	@Test
	public void bitonicArrayBig() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(29, mid);
	}
	
	@Test
	public void bitonicArrayBigLeftToMid() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,35,30,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(28, mid);
	}
	
	@Test
	public void bitonicArrayBigRightToMid() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,35,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(30, mid);
	}
	
	@Test
	public void bitonicArrayBigLeftRandom() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,90,80,70,60,30,35,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(15, mid);
	}
	
	@Test
	public void bitonicArrayExactlymid() {
		int[] arr = {10,19,20,25,24,1,0,-1};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(3, mid);
	}
	
	@Test
	public void bitonicArrayJustLeftTomid() {
		int[] arr = {10,19,26,25,24,1,0,-1};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(2, mid);
	}
	
	@Test
	public void bitonicArrayJustRightTomid() {
		int[] arr = {10,19,20,25,27,1,0,-1,-2};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(4, mid);
	}
	
	@Test
	public void bitonicArrayLeft1Odd() {
		int[] arr = {10,19,18,15,4,3,2,1,0};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(1, mid);
	}
	
	@Test
	public void bitonicArrayLeft1Even() {
		int[] arr = {10,19,18,15,4,3,2,1,0,-1};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(1, mid);
	}
	
	@Test
	public void bitonicArrayRight1Odd() {
		int[] arr = {10,19,18,19,20,21,22,25,24};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(7, mid);
	}
	
	@Test
	public void bitonicArrayRight1Even() {
		int[] arr = {10,19,18,19,20,21,22,23,24,15};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(8, mid);
	}
	
	@Test
	public void bitonicArraySize3() {
		int[] arr = {5,8,6};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(1, mid);
	}
	
	@Test
	public void InvalidbitonicArraySize3() {
		int[] arr = {9,8,6};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(-1, mid);
	}
	
	@Test
	public void InvalidbitonicArraySize3Right() {
		int[] arr = {9,10,11};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(-1, mid);
	}
	
	@Test
	public void invalidAscArray() {
		int[] arr = {10,19,20,25,26};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(-1, mid);
	}
	
	@Test
	public void invalidDescArray() {
		int[] arr = {25,24,5,4};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(-1, mid);
	}
	
	@Test
	public void invalidAllValuesEqualsArray() {
		int[] arr = {0,0,0,0};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(-1, mid);
	}
	
	@Test
	public void invalidAllValuesEquals1Array() {
		int[] arr = {1,1,1,1,1};
		int mid = BitonicArraySearch.findMidPoint(arr);
		Assertions.assertEquals(-1, mid);
	}
	
	@Test
	public void invalidLength() {
		int[] arr = {1,1};
		try {
			int mid = BitonicArraySearch.findMidPoint(arr);
						
		} catch(IllegalArgumentException ia) {
			if (ia.getMessage().equals("For Bitonic Array, Length should be minimum 3")) {
				Assertions.assertEquals(true, true);
			}
		}
	}
}
