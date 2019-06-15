/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

import java.util.Comparator;

/**
 * @author Thangaraj Jawahar
 *
 */
public class InitCapitalOrderComparator<T> implements Comparator<T> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		String s1 = (String) o1;
		String s2 = (String) o2;		
		return s1.charAt(0) > s2.charAt(0) ? 1 : 0;
	}
	
	public static void main(String args[]) {
		String s1 = "A";
		String s2 = "a";
		System.out.println(s1.charAt(0) > s2.charAt(0));
	}

}
