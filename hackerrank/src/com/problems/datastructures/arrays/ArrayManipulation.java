package com.problems.datastructures.arrays;

public class ArrayManipulation {

	public static void main(String[] args) {
		int n = 5;
		int[][] queries = { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 }, { 3, 4, 500 } };
		System.out.println(queries.length);
		System.out.println(arrayManipulation(n, queries));
	}

	static long arrayManipulation(int n, int[][] queries) {
		long[] arr = new long[n];
		long max = 0;
		for (int i = 0; i < queries.length; i++) {
			int start = queries[i][0] - 1;
			int end = queries[i][1] - 1;
			int k = queries[i][2];
			for (int j = start; j <= end; j++) {
				arr[j] = arr[j] + k;
				if (arr[j] > max) {
					max = arr[j];
				}
			}
		}
		return max;
	}

}
