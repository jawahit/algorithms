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
	
	public static boolean isLess(Comparable[] c, int a, int b) {
		return c[a].compareTo(c[b]) < 0;
	}
	
	public static boolean isGreater(Comparable[] c, int a, int b) {
		return c[a].compareTo(c[b]) > 0;
	}
	
	public static boolean isEqual(Comparable[] c, int a, int b) {
		return c[a].compareTo(c[b]) == 0;
	}
	
	public static void print(Comparable[] arr) {
		for (Object s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	

	public static void print(Object[] arr) {
		for (Object s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();

	}
}
