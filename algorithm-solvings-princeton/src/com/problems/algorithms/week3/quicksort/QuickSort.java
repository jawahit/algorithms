/**
 * 
 */
package com.problems.algorithms.week3.quicksort;

import java.util.Comparator;

import com.problems.algorithms.week2.sorting.Shuffling;
import com.problems.algorithms.week2.sorting.SortingUtils;
import com.problems.algorithms.week3.mergesort.MergeSort;

/**
 * {@code QuickSort} implementation <blockquote>
 * <p>
 * <b>Space complexity : </b><br>
 * worst - O(N)<br>
 * best - O(logN)<br>
 * average - O(Logn)<br>
 * <b>Time Complexity:</b><br>
 * worst - O(N^2/2)<br>
 * average - O(2N ln N)<br>
 * best - O(NlognN)
 * </p>
 * </blockquote> <blockquote> For ex:<br>
 * Worst Case:<br>
 * input is 19 total running count is : ( 19 ^ 2 /2)<br>
 * = 180.5 (u will get nearer to that value) <br>
 * Average Case:<br>
 * input is 19 total running count is : (19 * 2) * (4.247927513443585)<br>
 * = 161.421245511 (u will get nearer to that value)<br>
 * Best Case:<br>
 * input is 19 total running count is : 19 * (4.247927513443585)<br>
 * = 80.7 (u will get nearer to that value)<br>
 * </blockquote>
 * 
 * Feature: Faster performance Inplace Sorting (i.e., no additional space for
 * sorting like {@link MergeSort} thats why used for primitive datatypes sorting
 * 
 * Disadvantage: Not guaranteed Nlogn Duplicate keys might quadratic Not a
 * Stable sort
 * 
 * @author Thangaraj Jawahar
 * 
 */
public class QuickSort {

	static int compareCount = 0; // just get the compare count to calculate the performance

	public static void sort(Object[] c, Comparator comp) {
		compareCount = 0;
		if (comp == null) {
			Shuffling.sort((Comparable[]) c);
			System.out.print("Input: ");
			print(c);
			sort(c, 0, c.length - 1);
			System.out.print("Output: ");
			print(c);
			System.out.println("input size : "+ c.length);
			System.out.println("Running LoopCount:" +compareCount );
		}
	}

	public static void sort(Object[] c, int start, int end) {
		if (end <= start)
			return;
		int j = partioning(c, start, end);
		sort(c, start, j - 1);
		sort(c, j + 1, end);
	}
	public static int partioning(Object[] c, int i, int j) {
		int lowIndex = i;
		int hiIndex = j + 1;
		while (true) {
			compareCount++;
			while (lowIndex < j && ((Comparable) c[++lowIndex]).compareTo(c[i]) < 0) {
				compareCount++;
			}
			compareCount++;
			while (hiIndex > i && ((Comparable) c[--hiIndex]).compareTo(c[i]) > 0) {
				compareCount++;
			}
			if (hiIndex > lowIndex) {
				SortingUtils.exchange((Comparable[]) c, hiIndex, lowIndex);
			} else {
				break;
			}
		}
		SortingUtils.exchange((Comparable[]) c, i, hiIndex);
		return hiIndex;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		// String[] arr = {
		// "B","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R","W","R","B","W","R","B","W","R","B","W","R"};
	//	Integer[] arr = { 2, 4, 1, 5, 3 };
		int sum = 0;
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			sort(arr, null);
			sum += compareCount;
			System.out.println("running count :" + compareCount);
		}
		System.out.println("input size:" + arr.length);
		System.out.println("Average runnning time : " + sum / limit);

	}

	public static void print(Object[] arr) {
		for (Object s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

}
