/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import java.util.Arrays;

/**
 * 
 *  This class {@code FindKthElementFromTwoSortedArray} is based on binary search 
 *  Running time : O(logk)
 *  
 *  1.Take the kth index divide by  k/2 
 *  2.Find min out of arr1 size & k/2 as i
 *  3.Find min out of arr2 size & k/2 as j
 *  4.if ith element on Array1 > jth element on Array2.then from left to jth positions on array2's are ignored 
 *  since those elements go first when we do sorting and reduce the same j from k = k - j
 *  4.else do vice versa for Array1
 *  5.do recursive for remaining elements
 *  
 *  since the sorted elements on both the array it is better to 
 *  do binary search on both the arrays will be efficient solution
 *  
 * 
 * @author Thangaraj Jawahar
 *
 *         Jul 5, 2019
 * 
 *
 *
 * reference
 * https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 */
public class FindKthElementFromTwoSortedArray {

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1 = { 2, 3, 6, 7, 9 };
		Integer[] arr2 = { 10, 40, 80, 100 };
		int k = 1;
		Comparable a = findK(arr1, arr1.length, arr2, arr2.length, k);
		if ((Integer) a == -1) {
			System.out.println("Invalid Index");
		} else {
			System.out.println(a);
		}
	}

	public static Comparable findK(Comparable[] arr1, int a, Comparable[] arr2, int b, int k) {
		// base error conditions
		if (k < 1 || k > (a + b)) {
			return -1;
		}
		//if the first array becomes empty
		//return the kth element from second array
		if (a == 0)
			return arr2[k - 1];
		// if k is equal to total sizes of the array then return the bigger element
		if (k == a + b) {
			return arr1[a - 1].compareTo(arr2[b - 1]) > 0 ? arr1[a - 1] : arr2[b - 1];
		}
		// always we want to smaller array as arr1
		if (a > b) {
			return findK(arr2, b, arr1, a, k);
		}
		// this is the base condition to exit the recursive loop
		if (k == 1) { // base condition
			return arr1[0].compareTo(arr2[0]) <= 0 ? arr1[0] : arr2[0];
		}
		// get the min out of two arrays and reduce those indexes and reduce k as well
		int i = Math.min(a, k / 2);
		int j = Math.min(b, k / 2);
		// if the arr1 has bigger element ignore the arr2 elements left to jth value
		//and reduce k as  k - j since only the remaining elements on 2nd array we have to look
		if (arr1[i - 1].compareTo(arr2[j - 1]) > 0) { 
			Comparable[] temp = Arrays.copyOfRange(arr2, j, b);
			return findK(arr1, a, temp, b - j, k - j);
		}
		//and reduce k as  k - i since only the remaining elements on 1nd array we have to look
		Comparable[] temp1 = Arrays.copyOfRange(arr1, i, a);
		return findK(temp1, a - i, arr2, b, k - i);
	}

}
