package com.problems.algorithms.recursion;

import java.util.Scanner;


/* Please refer the below link
 * 
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 * 
 * 
 * 
 */
public class RecursiveDigitSum {

	static int digitSum(String n, int k) {
		char[] charArry = n.toCharArray();
		int a = sum(charArry, Integer.valueOf(String.valueOf(charArry[0])), 1);
		a = a * k;
		charArry = String.valueOf(a).toCharArray();
		a = sum(charArry, Integer.valueOf(String.valueOf(charArry[0])), 1);
		return a;
	}

	private static int sum(char[] charArry, int a, int index) {
		if (index >= charArry.length) {
			if (a >= 10) {
				int sum = a % 10;
				int divide = a / 10;
				a = sum + divide;
			}
			return a;
		}
		int s = a + Integer.valueOf(String.valueOf(charArry[index]));
		if (s >= 10) {
			int sum = s % 10;
			int divide = s / 10;
			s = sum + divide;
		}
		return sum(charArry, s, index + 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		int k = in.nextInt();
		int result = digitSum(n, k);
		System.out.println(result);
		in.close();
	}

}
