/**
 * 
 */
package com.problems.algorithms.week3.quicksort;

import java.util.Comparator;

import com.problems.algorithms.week2.sorting.Shuffling;
import com.problems.algorithms.week2.sorting.SortingUtils;

/**
 * @author Thangaraj Jawahar
 * 
 *         Space complexity :
 *           worst - O(N)
 *           best - O(logN)
 *           average - O(Logn)
 *         Time Complexity:
 *         	 best,average - O(Nlogn)
 * 		     worst - O(N^2)
 *         for ex: input is 19 total running count is : 19 * (4.247927513443585)
 *         = 80.7 (u will get nearer to that value)
 *
 */
public class QuickSort {

	static int runningCount = 0;

	public static void sort(Object[] c, Comparator comp) {
		runningCount = 0;
		if (comp == null) {
			Shuffling.sort((Comparable[]) c);
			System.out.print("Input: ");
			print(c);
			sort(c, 0, c.length - 1);
			System.out.print("Output: ");
			print(c);
			System.out.println("input size : "+ c.length);
			System.out.println("Running LoopCount O(NlogN):" +runningCount );
		}
	}

	public static void sort(Object[] c, int start, int hiIndex) {
		if (hiIndex <= start)
			return;
		runningCount++;
		int j = partioning(c, start, hiIndex);
		sort(c, start, j - 1);
		sort(c, j + 1, hiIndex);
	}

//	public static int partioning(Object[] c, int i, int j) {
//		int lowIndex = i;
//		int hiIndex = j + 1;
//		while (true) {
//			while (SortingUtils.isLess((Comparable[]) c, ++lowIndex, i)) {
//				if (lowIndex == j)
//					break;
//				runningCount++;
//			}
//			while (SortingUtils.isLess((Comparable[]) c, i, --hiIndex)) {
//				if (hiIndex == i)
//					break;
//				runningCount++;
//			}
//			if (hiIndex > lowIndex) {
//				SortingUtils.exchange((Comparable[]) c, lowIndex, hiIndex);
//			} else {
//				break;
//			}
//		}
//		SortingUtils.exchange((Comparable[]) c, i, hiIndex);
//		return hiIndex;
//	}

	public static int partioning(Object[] c, int i, int j) {
		int lowIndex = i;
		int hiIndex = j + 1;
		while (true) {
			while (lowIndex < j && ((Comparable) c[++lowIndex]).compareTo(c[i]) < 0) {
				runningCount++;

			}
			while (hiIndex > i && ((Comparable) c[--hiIndex]).compareTo(c[i]) > 0) {
				runningCount++;
			}
			if (hiIndex > lowIndex) {
				SortingUtils.exchange((Comparable[]) c,  hiIndex, lowIndex);
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
		int sum = 0;
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			sort(arr, null);
			sum += runningCount;
			System.out.println("running count :" + runningCount);
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
