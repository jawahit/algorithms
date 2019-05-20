/**
 * 
 */
package com.problems.algorithms.week2.stacks.problems;

import com.problems.algorithms.week2.stacks.StackUsingLinkedList;

/**
 * @author Thangaraj Jawahar
 *
 */
public class ImmediateMax {

	static int count = 0;

	public static int[] immediateMax(int[] a) {
		StackUsingLinkedList<Integer> inputStack = new StackUsingLinkedList<Integer>();
		int[] outputArray = new int[a.length];
		// this count is just to measure the loop count
		count = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			count++;
			while (!inputStack.isEmpty() && inputStack.peek() <= a[i]) {
				count++;
				inputStack.pop();
			}
			outputArray[i] = inputStack.isEmpty() ? -1 : inputStack.peek();
			inputStack.push(a[i]);

		}
		return outputArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 10, 6, 8, 2, 3, 4, 5, 9, 10, 11 };
		int[] arr1 = { 11, 10, 9, 8, 6, 6, 5, 4, 3, 2, 1, 0 };
		int[] out = immediateMax(arr);
		for (int i : out) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Done" + count);
	}

}
