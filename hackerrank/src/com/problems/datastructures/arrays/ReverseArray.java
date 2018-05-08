package com.problems.datastructures.arrays;

/**
 * {@link https://www.hackerrank.com/challenges/arrays-ds/problem}
 * 
 * 
 * @author jawahar
 *
 */
public class ReverseArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.println(reverseArray(a));
		for (Integer b : a) {
			System.out.println(b);
		}
	}

	static int[] reverseArray(int[] a) {
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			// swap the variables without using temp variables
			a[start] = a[start] + a[end];
			a[end] = a[start] - a[end];
			a[start] = a[start] - a[end];
			start++;
			end--;
		}
		return a;
	}

	

}
