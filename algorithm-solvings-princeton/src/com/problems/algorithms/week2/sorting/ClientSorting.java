/**
 * 
 */
package com.problems.algorithms.week2.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Thangaraj Jawahar
 *
 */
public class ClientSorting {
	
	public static void main(String args[]) {
		String[] flightNames = { "aa", "aab", "m" , "z" , "k"};
		AirTicket[] a = new AirTicket[10];
		for(int i = 0; i < a.length ; i++) {
			AirTicket air = new AirTicket();
			air.setPrice(StdRandom.uniform(500));
			air.setDuration(StdRandom.uniform(500));
			air.setFlightName("yuyu");
			a[i] = air;
		}		
		InsertionSort.sort(a);
		for(AirTicket air: a) {
			System.out.println(air.getFlightName());
			System.out.println(air.getPrice());
			System.out.println("----");
		}
		
		InsertionSort.sort(flightNames);
		for(String s: flightNames) {
			System.out.println(s);
		}
		
	}

}
