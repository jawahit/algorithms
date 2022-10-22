/**
 * 
 */
package com.problems.algorithms.week3.quicksort;

import java.util.Comparator;

import com.problems.algorithms.week2.sorting.Shuffling;
import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * {@code QuickSortWithTriplePartition} implementation with triple
 *  partioning logic<br>
 *  
 *  This is the efficient way of quicksort implementation best partitioning approach<br>
 *   you can compare the runningComaprecount with {@code QuickSort}
 *   
 *  And also this is most efficient if the all the values are same & more duplicates in the data
 *  For Ex: Dutchnational flag problem
 *  For ex: if dutch flag problem
 *   i/p - <br>
 *     B,R,W,R,R,R,R,R,R,B,R,R,B,R,B,B,B,R,B,R,W,W,W,W,W <br>
 *  o/p -  <br>
 *     B,B,B,B,B,B,B,R,R,R,R,R,R,R,R,R,R,R,R,W,W,W,W,W,W<br>
 *     
 *  Features:
 *    Mainly used for duplicate keys
 *    Inplace sorting
 *    
 *  DisAdvantages:
 *    Not Guaranteed Nlogn
 *       
 *     
 * @author Thangaraj Jawahar
 * 
 * 
 *         Jun 15, 2019
 * 
 *
 */
public class QuickSortWithTriplePartition {
	
	static int compareCount  = 0 ;

	public static void sort(Object[] c, Comparator com) {
		if (com == null) {
			compareCount = 0;
			Shuffling.sort((Comparable[]) c);
			System.out.print("Input: ");
			SortingUtils.print(c);
			sort(c, 0, c.length - 1);
			System.out.print("Output: ");
			SortingUtils.print(c);
			System.out.println("input size : "+ c.length);
			System.out.println("Running LoopCount:" +compareCount );
		}
	}

	public static void sort(Object[] c, int i, int j) {
		if (j <= i)
			return;
		int low = i;
		int high = j;
		int pIndex = i;
		Comparable p = (Comparable) c[i];
		while (pIndex <= high) {
			compareCount++;
			int comp = ((Comparable) c[pIndex]).compareTo(p);
			if (comp < 0)
				SortingUtils.exchange((Comparable[]) c, pIndex++, low++);
			else if (comp > 0)
				SortingUtils.exchange((Comparable[]) c, pIndex, high--);
			else
				pIndex++;
		}
		sort(c, i, low - 1);
		sort(c, high + 1, j);
	}

//	public static void duplicateOnlyFirstElementSorting(Object[] c, int i, int j) {
//		int low = i;
//		int high = j;
//		int mid = i + 1;
//		while (true) {
//
//			while (SortingUtils.isLess((Comparable[]) c, mid, low)) {
//				SortingUtils.exchange((Comparable[]) c, mid, low);
//				mid++;
//				low++;
//			}
//			while (SortingUtils.isGreater((Comparable[]) c, mid, low)) {
//				SortingUtils.exchange((Comparable[]) c, mid, high);
//				high--;
//			}
//			while (SortingUtils.isEqual((Comparable[]) c, mid, low)) {
//				mid++;
//			}
//			if (mid > high)
//				break;
//		}
//	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "B", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W",
				"R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B",
				"W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R",
				"B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W",
				"R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B",
				"W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R",
				"B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W",
				"R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R",
				"W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W",
				"R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B",
				"W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R",
				"B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W",
				"R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B",
				"W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R",
				"B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W",
				"R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B",
				"W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R" };
		sort(arr, null);
		SortingUtils.print(arr);
	}

}
