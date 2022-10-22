/**
 * 
 */
package com.problems.algorithms.week3.mergesort;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Thangaraj Jawahar
 *
 * Jul 19, 2021
 * 
 *
 */
public class TimeTest {

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR,50);
		System.out.println(calendar.getTime());
		Date date = calendar.getTime();
		long year50 = date.getTime()/1000;
		System.out.println(year50);
	    
//		long currentYear = 16268671081;
		
		

	}

}
