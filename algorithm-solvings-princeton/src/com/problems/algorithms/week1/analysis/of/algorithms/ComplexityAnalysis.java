/**
 * 
 */
package com.problems.algorithms.week1.analysis.of.algorithms;

/**
 * @author Thangaraj Jawahar
 *
 *         Oct 8, 2022
 * 
 *
 */
public class ComplexityAnalysis {

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		System.out.println("Array size: " + arr.length);
		System.out.println("O(N): " + oN(arr));
		System.out.println("O(N^2): " + oNSquare(arr));
		System.out.println("O(1/2N^2): " + oHalfNSquare(arr));
		System.out.println("O(logN): " + oLogN(arr));
		System.out.println("O(NlogN): " + oNLogN(arr));
	}

	public static int oN(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count++;
		}
		return count;
	}

	public static int oNSquare(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				count++;
			}
		}
		return count;
	}

	public static int oHalfNSquare(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				count++;
			}
		}
		return count;
	}

	public static int oLogN(int[] arr) {

		int count = 0;
		for (int i = 0; i <= Math.log(arr.length) + 1; i++) {
			count++;
		}
		return count;
	}

	public static int oNLogN(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= Math.log(arr.length) + 1; j++) {
				count++;
			}
		}
		return count;
	}

}
