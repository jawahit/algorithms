package com.problems.algorithms.week2.queues.assignment;
import edu.princeton.cs.algs4.StdIn;

/**
 * 
 */

/**
 * 
 * This class {@code Permutation} is a test class for {@link RandomizedQueue}
 * 
 * @author Thangaraj Jawahar
 *
 */
public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		while(!StdIn.isEmpty()) {
			queue.enqueue((StdIn.readString()));
		}
		for (int i = 0; i < k; i++) {
			System.out.println(queue.dequeue());
		}
	}

}
