/**
 * 
 */
package com.problems.algorithms.week4.priorityqueue;

import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 *         Jul 11, 2019
 * 
 *
 */
public class MaxPQUsingListTest {

	@Test
	public void randomTest() {
		MaxPQUsingList<String> maxPq = new MaxPQUsingList<String>();
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
	}

}
