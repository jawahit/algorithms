/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 * Jul 14, 2019
 * 
 *
 */
public class MinPQTest {
	
	@Test
	public void randomTest() {
		MinPQ<String> maxPq = new MinPQ<String>(20);
		maxPq.insert("O");
		maxPq.insert("R");
		maxPq.insert("A");
		maxPq.insert("P");
		maxPq.insert("N");
		maxPq.insert("S");
		maxPq.insert("E");
		maxPq.insert("I");
		maxPq.insert("G");
		maxPq.insert("T");
		maxPq.printList();
		System.out.println(maxPq.delMin());
		maxPq.printList();
		maxPq.insert("M");
		maxPq.insert("A");
		maxPq.insert("B");
		maxPq.printList();
		System.out.println(maxPq.delMin());
		maxPq.printList();
		while(!maxPq.isEmpty()) {
			maxPq.delMin();
			maxPq.printList();
		}
	}

}
