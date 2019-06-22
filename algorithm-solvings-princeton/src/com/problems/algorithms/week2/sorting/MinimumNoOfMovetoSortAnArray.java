/**
 * 
 */
package com.problems.algorithms.week2.sorting;

/**
 * 
 * {@code MinimumNoOfMovetoSortAnArray} is just to find how many moves needs to be done
 * to sort an array.
 * 
 * constraints: all elements in the array should be distinct
 * 
 * sorting this way is of course quadratic time
 * but the move is just O(N)
 *  this program is just to find the number of moves not to sort the array 
 * 
 * <blockquote>
 * Steps:<br>
 *   
    1. if the array is sorted, stop. <br>
    2. find the smallest element that appears before a smaller element in the array<br>
    3. move that element to the end<br>
    4. go to 1.<br>
  </blockquote>
 * <blockquote>
 * For Ex1:
 * 
 *    I/p: 5 3 1 2<br>
 *    Process:<br>
 *         5 1 2 3<br>
 *         1 2 3 5 - sorted<br>
 *    So totally two moves to be done to sort an array. ans is 2
 * </blockquote>
 * <blockquote>  
 * For Ex2:
 *   <code>
 *    I/p: 8 6 1 7 5 2 3 9<br>
 *    Process:<br>
 *         8 6 1 7 2 3 9 5<br>
 *         8 1 7 2 3 9 5 6<br>
 *         8 1 2 3 9 5 6 7<br>
 *         1 2 3 9 5 6 7 8<br>
 *         1 2 3 5 6 7 8 9 - > sorted<br>
 *      So totally 5 moves to be done to sort an array. ans is 5
 *   </code>
 *   
 * </blockquote>   
 *
 *
 *credits:
 *https://stackoverflow.com/users/1011995/daniel-fischer
 * 
 *
 */
public class MinimumNoOfMovetoSortAnArray {
	
	
	
	public static int findNumberOfMoves(int[] arr) {
		int n = arr.length;
		int j = n - 1;
		while(j > 0 && arr[j-1] < arr[j]) j--;
		//since array is already sorted
		if(j == 0 ) return 0;
		int smallest = arr[j]; int smaller = arr[j-1];
		j -= 2;
		while(j >= 0) {
			if(arr[j] < smallest) {
				smallest = arr[j];
			}else if(arr[j] < smaller) {
				smaller = arr[j];
			}
			j--;
		}
		int small = 0;
		for(j = 0 ; j < n;j++ ) {
			if(arr[j] < smaller) small++; 
		}
		return n - small;
	}
	

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,1,2,3,7,8,9};
		System.out.println(findNumberOfMoves(arr));
	}

}
