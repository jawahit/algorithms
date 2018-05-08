package com.problems.datastructures.arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int size = a.length;
		int r = 12;
		if (r == size || r == 0) {
			System.out.print(a);
		} else if (r > size) {
			r = r % size;
		}
		int[] b = rotate(a, r);
		for (int i : b) {
			System.out.print(i);
		}
	}

	public static int[] rotate(int[] a, int r) {
		int size = a.length;
		for (int i = 0; i < gcd(size, r); i++) {
			int storeIndex = i;
			int getIndex = i + r;
			int temp = a[i];
			while (getIndex != i) {
				a[storeIndex] = a[getIndex];
				storeIndex = getIndex;
				getIndex += r;
				if (getIndex >= size) {
					getIndex = getIndex - size;
				}
			}
			a[storeIndex] = temp;
		}
		return a;
	}

	/*
	 * need to get the common divisor out of two numbers(rotation ,array.size);
	 * so we can GCD or HCF concept to get that
	 * 
	 */
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
