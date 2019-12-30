/**
 * 
 */
package com.problems.algorithms.week6.hashtable;

import java.util.HashMap;

/**
 * @author Thangaraj Jawahar
 *
 * Nov 17, 2019
 * 
 * so if you override only hashcode - it will return null for correct value and also duplicate values will be inserted
 * so if you override only equals - it will return will null for correct value and also duplciate values will be inserted
 * 
 *
 */
public class HashMapCheck {

	/**
	 *
	 *void
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Employee, Integer> hashMap = new HashMap<Employee, Integer>();
		hashMap.put(new Employee(1,"jawas"), 1);
		hashMap.put(new Employee(1,"jawas"), 1);
		System.out.println(hashMap.get(new Employee(1,"jawas")));

	}

}
