package com.problems.algorithms.search;

import java.util.Arrays;

/* TODO
 * Please refer https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
 * 
 * Problem : 
 * 
 *    Hackerland is a one-dimensional city with  houses, where each house  is located at some  on the -axis. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each transmitter has a range, , meaning it can transmit a signal to all houses  units of distance away.

	  Given a map of Hackerland and the value of , can you find and print the minimum number of transmitters needed to cover every house in the city? (Every house must be covered by at least one transmitter) Each transmitter must be installed on top of an existing house.

	Input Format

	The first line contains two space-separated integers describing the respective values of  (the number of houses in Hackerland) and  (the range of each transmitter). 
	The second line contains  space-separated integers describing the respective locations of each house (i.e., ).
 * 
 * Sample Input 

		5 1
		1 2 3 4 5
   Sample Output
		
		2

 * 
 */

public class HackerlandTransmitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] hackerLand = { 2, 4, 5,6,7};
		int k = 1;
		System.out.println(getCount(hackerLand.length,k,hackerLand));

	}
	
	public static int getCount(int n,int k,int[] x){
		Arrays.sort(x);
        int tcount = 0;
		boolean fixed = false;
		boolean recentlyFixed = false;
		for (int i = 0; i < x.length - 1; i++) {
			int diff = x[i + 1] - x[i];
			if (diff > k) {
				tcount++;
                recentlyFixed = true;
			} else {
				if (fixed) {
					tcount++;
					fixed = false;
					recentlyFixed = true;
				} else if (recentlyFixed) {
					recentlyFixed=false;
				} else {
					fixed = true;
					recentlyFixed=false;
				}
			}
		}
		if(fixed){
			tcount++;
		}
        return tcount;
    }

}
