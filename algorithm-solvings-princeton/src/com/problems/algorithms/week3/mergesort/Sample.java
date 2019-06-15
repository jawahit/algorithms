/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

/**
 * @author Thangaraj Jawahar
 *
 */
public class Sample {

	
	public static void main(String[] args) {

		int start = 0;
		int end = 15;
		int sum = start + end;
//		System.out.println((start + (end - start)) / 2);
//		System.out.println(sum >>> 1);
//
//		System.out.println(7 % 2);
		System.out.println(sum >>> 1);
		System.out.println(sum/2);
		recursivePrint(0, 4);
		System.out.println(Double.NEGATIVE_INFINITY);
	

	}

	public static void recursivePrint(int start, int end) {	
		int mid = (start + end) / 2;
		if (start == end) {
			return;
		}
		recursivePrint(start, mid);
		recursivePrint(mid+1, end);
		System.out.println("start: " + start + " mid: " + mid + " end: " +end);
	}
	

}
