package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;


/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 * 
 * @author jawahar
 *
 */
public class MaxElement {
	static Stack<Integer> mainStack = new Stack<>();
	static Stack<Integer> maxStack = new Stack<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int p_i = 0; p_i < n; p_i++) {
			int action = in.nextInt();
			if (action == 1) {
				int val = in.nextInt();
				// if stack is empty push the first value in to both the stacks
				if (mainStack.isEmpty()) {
					mainStack.push(val);
					maxStack.push(val);
					continue;
				}
				mainStack.push(val);
				int top = maxStack.peek();
				// the push the latest max value in to maxstack if val is
				// greater than peek
				if (val >= top) {
					maxStack.push(val);
				}
			} else if (action == 2) {
				int data = mainStack.pop();
				int top = maxStack.peek();
				if (top == data) {
					maxStack.pop();
				}
			} else {
				System.out.println(maxStack.peek());
			}
		}
		in.close();

	}
}
