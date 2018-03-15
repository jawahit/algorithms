package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;


/**
 * {@link https://www.hackerrank.com/challenges/game-of-two-stacks/problem}
 * 
 * @author jawahar
 *
 */
public class GameofTwoStacks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int constraint = in.nextInt();
			int totalIntegers = 0;
			int sumOfIntegers = 0;
			int i = 0;
			Stack<Integer> gameStack = new Stack<>();
			boolean notReached = false;
			//fill the first stack till  <=constraint
			while (i < n) {
				int v = in.nextInt();
				if ((sumOfIntegers + v) <= constraint && !notReached) {
					sumOfIntegers = sumOfIntegers + v;
					gameStack.push(v);
				} else if (!notReached) {
					notReached = true;
					break;
				}
				i++;
			}
			in.nextLine();
			totalIntegers = i;
			int j = 0;
			//fill second stack and remove top of the first stack if sumCount> constraint and keep the count
			while (j < m && (i >= 0 && sumOfIntegers<=constraint)) {
				int v = in.nextInt();
				sumOfIntegers += v;
				j++;
				while (sumOfIntegers > constraint && i > 0) {
					sumOfIntegers = sumOfIntegers - gameStack.pop();
					i--;
				}
				if (sumOfIntegers <= constraint && (i + j > totalIntegers)) {
					totalIntegers = i + j;
				}
			}
			System.out.println(totalIntegers);
			in.nextLine();
		}
		in.close();
	}

}
