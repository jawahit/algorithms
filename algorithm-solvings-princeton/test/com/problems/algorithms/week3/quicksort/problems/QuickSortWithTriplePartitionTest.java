/**
 * 
 */
package com.problems.algorithms.week3.quicksort.problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.problems.algorithms.week3.mergesort.Point;
import com.problems.algorithms.week3.quicksort.QuickSortWithTriplePartition;

import edu.princeton.cs.algs4.In;

/**
 * @author Thangaraj Jawahar
 *
 *         Jun 16, 2019
 * 
 *
 */
public class QuickSortWithTriplePartitionTest {
	@Test
	public void checkForLengthLessThan5() {
		Integer[] arr = { 5, 4, 1, 2, 6 };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void alreadySorted() {
		Integer[] arr = { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3 };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForLongerValues() {
		Integer[] arr = { 4, 5, 1, 2, 6, 8, 2, 1, 3, 4, 5, 6, 9, 11, 2, 7, 2, 5, 56, -1, -3, 3, 1, 98, -100, -98, 67,
				-56 };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForStringValues() {
		String[] arr = { "zebra", "apple", "orange", "mango", "coconut", "gauva" };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void moreDatas() {
		String[] arr = { "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
				"E", "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E",
				"Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q",
				"Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q",
				"U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U",
				"I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I",
				"C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C",
				"K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K",
				"S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K", "S",
				"O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K", "S", "O",
				"R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K", "S", "O", "R",
				"T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T",
				"I", "N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I",
				"N", "G", "E", "X", "A", "M", "P", "L", "E", "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N",
				"G", "E", "X", "A", "M", "P", "L", "E" };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void distincyKeysSorting() {
		String[] arr = new String[350];
		for (int i = 0; i < 350; i++) {
			arr[i] = Double.toString(Math.random() + i);
		}
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void AllkeysareSame() {
		String[] arr = new String[350];
		for (int i = 0; i < 350; i++) {
			arr[i] = "A";
		}
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void dutchFlagSortingQuickSortWithTriplePartition() {
		String[] arr = { "B", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W",
				"R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B",
				"W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R",
				"B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W",
				"R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B",
				"W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R",
				"B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W",
				"R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R",
				"W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W",
				"R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B",
				"W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R",
				"B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W",
				"R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B",
				"W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R",
				"B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W",
				"R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B",
				"W", "R", "B", "W", "R", "B", "W", "R", "W", "R", "B", "W", "R", "B", "W", "R", "B", "W", "R" };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForAlphabetValues() {
		String[] arr = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
				"E" };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void quickSortExample() {
		String[] arr = { "Q", "Q", "U", "I", "C", "K", "S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L",
				"E" };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForFullyDescendingOrderValues() {
		Integer[] arr = { 100, 99, 1, 2, 98, 97, 96, 50, 45, 34, 23, 12, 2, 1 };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	@Test
	public void checkForLongerStringWithNumber() {
		String[] arr = { "31415926535897932384626433832795", "1", "3", "10", "3", "5" };
		QuickSortWithTriplePartition.sort(arr, null);
		assertEquals(true, isSorted(arr));
	}

	// @Test
	public void testInitCapsWithComparator() {
		String[] arr = { "zerba", "apple", "Apple", "Orange", "orange", "Zebra", "potato", "Potato" };
		// QuickSortWithTriplePartition.sort(arr,new
		// InitCapitalOrderComparator<String>());
		assertEquals(true, isSorted(arr));
	}

	// @Test
	public void testinput8() {
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\input8.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		QuickSortWithTriplePartition.sort(points, null);
		assertEquals(true, isSorted(points));
	}

	// @Test
	public void testinput80() {
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\input80.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		// QuickSortWithTriplePartition.sort(points,null);
		assertEquals(true, isSorted(points));
	}

	// @Test
	public void testinputrs1423() {
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\rs1423.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		// QuickSortWithTriplePartition.sort(points,null);
		assertEquals(true, isSorted(points));
	}

	// @Test
	public void testinput8WithComparator() {
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\input8.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		// QuickSortWithTriplePartition.sort(points,null);
		Point[] aux = new Point[n];
		// copyArray(points, aux, 0, points.length-1);
		for (int i = 0; i < n; i++) {
			Point[] p = new Point[n];
			copyArray(points, p, 0, points.length - 1);
			// QuickSortWithTriplePartition.sort(p,points[i].slopeOrder());
			assertEquals(true, isSortedWithComparator(p, points[i]));
		}
	}

	// @Test
	public void testinput8WithComparatorArraySort() {
		System.out.println("Test with Array Sort>>>>");
		In in = new In("C:\\Users\\thangj3\\Desktop\\pers\\Alg1\\collinear\\input8.txt");
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		Arrays.sort(points, null);
		for (int i = 0; i < n; i++) {
			Point[] aux = new Point[n];
			copyArray(points, aux, 0, points.length - 1);
			Arrays.sort(points, aux[i].slopeOrder());
			assertEquals(true, isSortedWithComparator(points, aux[i]));
		}
	}

	@Test
	public void doubleArrayTestSort() {
		Double[] dArray = { -1.75, -1.0, -1.0, -0.5714285714285714, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY,
				-1.0, 3.75, 2.1, +0.0 };
		QuickSortWithTriplePartition.sort(dArray, null);
		for (int i = 0; i < dArray.length; i++) {
			System.out.print(dArray[i] + " ");
		}
		assertEquals(true, isSorted(dArray));
	}

	private static void copyArray(Object[] src, Object[] dest, int start, int end) {
		for (int i = start; i <= end; i++) {
			dest[i] = src[i];
		}
	}

	private boolean isSortedWithComparator(Point[] arr, Point p) {
		boolean sorted = true;
		Double[] slopes = new Double[arr.length];
		Double slopeVal = null;
		System.out.print("src:" + p + " ");
		for (int i = 0; i < arr.length; i++) {
			slopes[i] = p.slopeTo(arr[i]);
			slopeVal = slopes[i];
			System.out.print(slopeVal + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return sorted;
	}

	private boolean isSorted(Object[] arr) {
		boolean sorted = true;
		for (int i = 1; i < arr.length; i++) {
			if (((Comparable) (arr[i - 1])).compareTo(arr[i]) > 0) {
				sorted = false;
				break;
			}
		}
		return sorted;
	}

}
