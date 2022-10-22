/**
 * 
 */
package com.problems.algorithms.week2.sorting;

/**
 * @author Thangaraj Jawahar
 *
 *         Jun 19, 2019
 * 
 *
 */
public class SelectionSort {
	static int noOfSwaps;
	public static int sort(Object[] c) {
		for (int i = 0; i < c.length; i++) {
			int min = i;
			for (int j = i + 1; j < c.length; j++) {
				if (SortingUtils.isLess((Comparable[]) c, j, min)) {
					min = j;
				}
			}
			if(min != i) {
				noOfSwaps++;
				SortingUtils.exchange((Comparable[]) c, min, i);
			}
		}
		return noOfSwaps;
	}
	
	public static int move_count(int[] a) {
		int n = a.length;
	    int j = n-1;
	    while(j > 0 && a[j-1] < a[j]) --j;
	    if (j == 0) return 0;   
	    int min_val = a[j], v_1 = a[j-1];
	    j -= 2;
	    while(j >= 0) {
	        if (a[j] < min_val) {
	            min_val = a[j];
	        } else if (a[j] < v_1) {
	            v_1 = a[j];
	        }
	        --j;
	    }
	    int count_smaller = 0;
	    for(j = 0; j < n; ++j) {
	        if (a[j] < v_1) ++count_smaller;
	    }
	    return n - count_smaller;
	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] arr = { 1,2,3,4,5,7, 10, 5, 3,11,1, 8, 4, 2, 9, 6 };
		//Integer[] arr = { 7,1,3,2,4,5,6};
		//Integer[] arr = { 2,3,4,1,5};
		int[] arr = { 1,3,5,2,4,6,7};
		//int[] a = {4, 3, 1, 2};
		//int[] a = {6, 1, 2,3,4,5,7,8,9,10};
		int[] a = {80,9,6,4, 1, 5, 2};
		
		
//		sort(arr);
//		SortingUtils.print(arr);
		//System.out.println("number of swaps:" +noOfSwaps);
		System.out.println(move_count(a));
	}

}
