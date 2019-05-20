/**
 * 
 */
package com.problems.algorithms.week2.stacks.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 */
public class ImmediateMaxTest {

	@Test
	public void checkNormalData() {
		ImmediateMax immediateMax = new ImmediateMax();
		int[] input = { 1, 5, 3, 10, 6, 8, 2, 3, 4, 5, 9, 10, 11 };
		int[] actuals = immediateMax.immediateMax(input);
		int[] expected = { 5, 10, 10, 11, 8, 9, 3, 4, 5, 9, 10, 11, -1 };
		Assert.assertArrayEquals(expected, actuals);

	}

}
