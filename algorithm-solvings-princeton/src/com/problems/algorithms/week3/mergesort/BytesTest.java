/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

/**
 * @author Thangaraj Jawahar
 *
 * Jul 24, 2021
 * 
 *
 */
public class BytesTest {

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc*";
		for(byte b: s.getBytes()) {
			System.out.println(b);	// returns ascii decimal value		
		}
		
		int i = 127;
		System.out.println(Integer.toBinaryString(i));

	}

}
