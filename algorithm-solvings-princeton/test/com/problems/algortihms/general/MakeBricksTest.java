/**
 * 
 */
package com.problems.algortihms.general;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Thangaraj Jawahar
 *
 */
public class MakeBricksTest {

	@Test
	public void testcorrectbricks() {

		assertTrue(MakeBricks.makeBricks(2, 2, 10));
	}

	@Test
	public void testLesserbricks() {

		assertFalse(MakeBricks.makeBricks(2, 1, 10));
	}

	@Test
	public void testLargerbricks() {

		assertFalse(MakeBricks.makeBricks(2, 1, 20));
	}

	@Test
	public void testExactbricks() {

		assertTrue(MakeBricks.makeBricks(3, 1, 8));
	}

}
