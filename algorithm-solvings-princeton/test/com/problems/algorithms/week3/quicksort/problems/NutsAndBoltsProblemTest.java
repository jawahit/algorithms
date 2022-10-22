/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import java.util.stream.IntStream;

import org.junit.Test;

import com.problems.algorithms.week2.sorting.Shuffling;

/**
 * @author Thangaraj Jawahar
 *
 *         Jun 29, 2019
 * 
 *
 */
public class NutsAndBoltsProblemTest {

	@Test
	public void decreasedOrder() {
		Integer[] nuts = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Integer[] bolts = { 10, 9, 1, 2, 3, 4, 5, 7, 6, 8 };
		NutsAndBoltsProblem.findPairs(nuts, bolts);
	}

	@Test
	public void shuffledFor100Times() {
		Integer[] nuts = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Integer[] bolts = { 10, 9, 1, 2, 3, 4, 5, 7, 6, 8 };
		IntStream.iterate(0, i -> i).limit(100).forEach(i -> {
			Shuffling.sort(nuts);
			Shuffling.sort(bolts);
			NutsAndBoltsProblem.findPairs(nuts, bolts);
		});
	}

}
