package com.problems.datastructures.arrays;

import java.util.Random;

/**
 * To shuffle the array randomly
 * 
 * @author jawahar
 *
 */
public class ShuffleArray {

	static final Random randomNumberGenerator = new Random();

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = shuffle(a);
		for (Integer s : b) {
			System.out.println(s);
		}
	}

	public static int[] shuffle(int a[]) {
		int len = a.length - 1;
		for (int i = 0; i <= len; i++) {
			int randomIndex = getRandom(len);
			int temp = a[randomIndex];
			a[randomIndex] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static int getRandom(int length) {
		return randomNumberGenerator.nextInt(length);
	}

}
