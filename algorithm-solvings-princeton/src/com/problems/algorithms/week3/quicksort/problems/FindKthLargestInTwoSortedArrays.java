/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * @author Thangaraj Jawahar
 *
 *         Jun 23, 2019
 * 
 *
 */
public class FindKthLargestInTwoSortedArrays {

	public static Object findKthLargest(Object[] n1, Object[] n2, int k) {
		Object[] n = new Object[n1.length + n2.length];
		if(k <= 0 || k > n.length) {
			throw new IllegalArgumentException("K shouldn't outside of range");
		}
		int n1i = 0, n2i = 0, ni = 0;
		int nsize = n.length - 1, n1Size = n1.length-1 , n2size = n2.length -1;
		while (ni <= nsize) {
			if (((Comparable) n1[n1i]).compareTo((Comparable) n2[n2i]) < 0) {
				n[ni++] = n1[n1i++];
			} else if (((Comparable) n1[n1i]).compareTo((Comparable) n2[n2i]) > 0) {
				n[ni++] = n2[n2i++];
			} else {
				n[ni++] = n1[n1i++];
				n[ni++] = n2[n2i++];
			}
			if((n1i > n1Size) || (n2i > n2size)) {
				if(n1i <= n1Size) {
					while(n1i <= n1Size)
					n[ni++] = n1[n1i++];
				}

				if(n2i <= n2size) {
					while(n2i <= n2size)
						n[ni++] = n2[n2i++];
				}
			};
		}
		
		SortingUtils.print(n);
		return n[n.length - k];
	}

	/**
	 *
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] n1 = {1,2,3,4 };
		Integer[] n2 = {1,2,3,4,5,6,7,8,9,10 };
		System.out.println(findKthLargest(n1, n2, 9));
	}

}
