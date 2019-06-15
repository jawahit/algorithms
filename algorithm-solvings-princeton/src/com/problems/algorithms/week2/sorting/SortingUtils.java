/**
 * 
 */
package com.problems.algorithms.week2.sorting;

/**
 * @author Thangaraj Jawahar
 *
 */
public class SortingUtils {
	public static void exchange(Comparable[] c, int a, int b) {
		Comparable<?> o =  c[a];
		c[a] = c[b];
		c[b] = o;
	}
	
	public static void isLessThenSwap(Comparable[] c, int a, int b) {
		if(c[b].compareTo(c[a]) < 0) {
			exchange(c, b, a);
		}
	}
}
