/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 *         Jul 14, 2019
 * 
 *
 */
public class MaxPQTest {

	@Test
	public void randomTest() {
		MaxPQ<String> maxPq = new MaxPQ<String>();
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
		System.out.println(maxPq.size());
		maxPq.printList();
		maxPq.delMax();
		maxPq.printList();
		maxPq.insert("M");
		maxPq.insert("A");
		maxPq.printList();
		while (!maxPq.isEmpty()) {
			maxPq.delMax();
			maxPq.printList();
		}
	}

}
