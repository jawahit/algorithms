package com.problems.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/waiter/problem
 * 
 * 
 * @author jawahar
 *
 */
public class Waiter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int iterationStart = 0;
		Stack<Integer> bStack = new Stack<Integer>();
		Stack<Integer> aStack = new Stack<Integer>();
		List<Stack> stackList = new ArrayList();
		for (int number_i = 0; number_i < n; number_i++) {
			aStack.push(in.nextInt());
		}
		for (int i = 0; i < q; i++) {
			aStack = perform(aStack, stackList, i + 1);
		}
		stackList.add(aStack);
		for (Stack stack : stackList) {
			for (int i = stack.size() - 1; i >= 0; i--) {
				System.out.println(stack.get(i));
			}
		}
	}

	public static Stack<Integer> perform(Stack<Integer> aStack, List<Stack> listStack, int iterationStart) {
		Stack<Integer> bkupStack = new Stack<Integer>();
		Stack<Integer> bStack = new Stack<Integer>();
		for (int j = aStack.size() - 1; j >= 0; j--) {
			int prime = nthPrime(iterationStart);
			int val = aStack.get(j);
			if (val % prime == 0) {
				bStack.add(val);
			} else {
				bkupStack.push(aStack.get(j));
			}
		}
		listStack.add(bStack);
		return bkupStack;
	}

	public static int nthPrime(int n) {
		int candidate, count;
		for (candidate = 2, count = 0; count < n; ++candidate) {
			if (isPrime(candidate)) {
				++count;
			}
		}
		// The candidate has been incremented once after the count reached n
		return candidate - 1;
	}

	public static boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++)
			if (N % i == 0)
				return false;
		return true;
	}
}
