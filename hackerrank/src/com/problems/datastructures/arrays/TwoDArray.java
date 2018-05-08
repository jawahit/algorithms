package com.problems.datastructures.arrays;

/**
 * 
 * {@link https://www.hackerrank.com/challenges/2d-array/problem}
 * 
 * @author jawahar
 *
 */
public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2 } };
		System.out.println(getMaxArray2D(arr));
	}

	static int array2D(int[][] arr, int i, int ij, int j, int jj, int k) {
		int sum = 0;
		sum += arr[i][ij];
		sum += arr[i][ij + 1];
		sum += arr[i][ij + 2];
		sum += arr[j][jj];
		sum += arr[k][ij];
		sum += arr[k][ij + 1];
		sum += arr[k][ij + 2];
		return sum;
	}

	static int getMaxArray2D(int[][] arr) {
		int i = 0, ij = 0, j = 1, jj = 1, k = 2;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		while (k <= 5) {
			sum = array2D(arr, i, ij, j, jj, k);
			max = sum > max ? sum : max;
			ij++;
			jj++;
			if (ij > 3) {
				k++;i++;ij = 0;j++;jj = 1;
			}
		}
		return max;
	}
}
