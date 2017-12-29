package com.problems.mathematics.numbertheory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/* Please refer https://www.hackerrank.com/challenges/little-chammys-huge-donation/problem
 * 
 * 
 * 
 * 
 */

public class LittleAshishHugeDonation {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		if (i >= 1 && i <= 10000) {
			for (int j = 0; j < i; j++) {
				BigDecimal k = scan.nextBigDecimal();
				if (k.compareTo(new BigDecimal(0)) == 1 && k.compareTo(new BigDecimal(Math.pow(10, 17))) == -1) {
					System.out.println(findN(k));
				} else {
					System.out.println("input is not valid");
				}
			}
		} else {
			System.out.println("First line of input is not valid");
		}
		scan.close();
	}

	public static BigDecimal findN(BigDecimal input) {
		BigDecimal multipliedOfThree = input.multiply(new BigDecimal(3));
		Double cubeRootedValue = Math.cbrt(multipliedOfThree.doubleValue());
		return verifySumOfSquaresFormulae(cubeRootedValue, input);
	}

	public static BigDecimal verifySumOfSquaresFormulae(Double d, BigDecimal input) {
		BigDecimal b = new BigDecimal(d).setScale(0, RoundingMode.DOWN);
		// n(n+1)
		BigDecimal firstPlus1 = b.add(new BigDecimal(1));
		BigDecimal first = new BigDecimal(d).setScale(0, RoundingMode.DOWN).multiply(firstPlus1);
		// 2n+1
		BigDecimal second = new BigDecimal(2).multiply(new BigDecimal(d).setScale(0, RoundingMode.DOWN)).setScale(0,
				RoundingMode.DOWN);
		BigDecimal secondPlus1 = second.add(new BigDecimal(1));
		// n(n+1)*(2n+1)
		BigDecimal multiply2 = first.multiply(secondPlus1);
		// divide above by 6
		BigDecimal output = multiply2.divide(new BigDecimal(6)).setScale(0, RoundingMode.DOWN);

		if (input.compareTo(output) == 0 || input.compareTo(output) == 1) {
			return new BigDecimal(d).setScale(0, RoundingMode.DOWN);
		} else {
			return verifySumOfSquaresFormulae(d - 1, input);
		}
	}

}
