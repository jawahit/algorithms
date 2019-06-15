/**
 * 
 */
package com.problems.algorithms.week1.analysis.of.algorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * This class {@code DigitSumUsingBinarySearch} is used to give the count of any
 * three values of sum produces zero For Ex: -40 -20 60 if you sum the above
 * three values it gives zero Order Of Growth N^2logN in this below sample array
 * is sorted if it's not for sorting th O(N) = N^2 N^2logN
 * 
 * @author Thangaraj Jawahar
 *
 */
public class DigitSumUsingBinarySearch {

	public static void main(String[] args) {
		// arrays are in sorted order
		int[] a = { -40, -20, -10, 0, -5, 10, 30, 40};
	   //	Arrays.sort(a);
		Stopwatch stopwatch1 = new Stopwatch();
		ThreeSumBruteForce(a);
		System.out.println(stopwatch1.elapsedTime());
		Stopwatch stopwatch = new Stopwatch();
		ThreeSumUsingBinarySearch(a);
		System.out.println(stopwatch.elapsedTime());

	}

	public static void ThreeSumUsingBinarySearch(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int sum = (a[i] + a[j]);
				if (a[i] < a[j] && a[j] < -sum) { // to avoid duplicate count
					if (BinarySearch.binarySearch(a, -sum) != -1) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static void ThreeSumBruteForce(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
