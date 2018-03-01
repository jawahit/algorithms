package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/and-xor-or/problem
 * 
 * @author jawahar
 *
 */
public class ANDxorOR {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		System.out.println(doIteration(A));
		// System.out.println(doAndXorOr(5, 11));
	}

	public static int doAndXorOr(int m1, int m2) {
		return m1 ^ m2;
	}

	public static int doIteration(int[] A) {
		Stack<Integer> minPairStack = new Stack<>();
		int max = doAndXorOr(A[0], A[1]);
		for (int i = 0; i <= A.length - 1; i++) {
			int indexVal = A[i];
			while (!minPairStack.isEmpty()) {
				int top = minPairStack.peek();
				int sI = doAndXorOr(top, indexVal);
				if (sI > max) {
					max = sI;
				}
				if (indexVal < top) {
					minPairStack.pop();
				} else {
					break;
				}
			}
			minPairStack.push(indexVal);
		}
		return max;
	}

}
