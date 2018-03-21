package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * {@link https://www.hackerrank.com/challenges/largest-rectangle/problem}
 * 
 * @author jawahar
 * 
 * 
 * Sample inputs:
 *  12
	14
	1 2 3 4 5 4 4 3 3 2 1 1 1 1
	12
	5 5 5 4 3 3 3 4 4 5 2 1
	13
	3 3 3 5 2 5 4 6 2 4 4 6 2
	6
	1 2 3 4 5 6
	6
	6 5 4 3 2 1
	9 
	4 4 3 2 1 2 3 4 1
	5
	1 2 3 5 4
	5
	1 2 4 5 3
	4
	1 2 5 1
	4
	1 1 1 1
	2
	5 2
	2
	2 5
 *
 */
public class LargestRectangle {

	static long largestRectangle(int[] h) {
		long max = 0;
		int lastBuilding = h[0];
		int currentBuilding = h[1];
		Stack<Integer> buildingStack = new Stack<>();
		if (buildingStack.isEmpty()) {
			buildingStack.push(lastBuilding);
		}
		boolean fullBuildingCovered = false;
		int lowerBuilding = currentBuilding;
		// iterate and push to stack till u get the lower value than the last
		// one
		for (int i = 1; i < h.length;) {
			while (currentBuilding >= lastBuilding && i < h.length) {
				buildingStack.push(currentBuilding);
				i++;
				if (i == h.length) {
					currentBuilding = lastBuilding;
					lastBuilding = buildingStack.peek();
					fullBuildingCovered = true;
					break;
				}
				lastBuilding = currentBuilding;
				currentBuilding = h[i];
				lowerBuilding = currentBuilding;
			}
			if (fullBuildingCovered) {
				lowerBuilding = 0;
			}
			int count = 0;
			// pop and level the building by removing max values
			while (!buildingStack.isEmpty() && lastBuilding > lowerBuilding) {
				if (lastBuilding >= currentBuilding) {
					count++;
					max = setMax(max, lastBuilding, count);
					lastBuilding = buildingStack.pop();
					if (buildingStack.isEmpty() && lowerBuilding != 0) {
						while (count > 0) {
							buildingStack.push(lowerBuilding);
							count--;
						}
						lastBuilding = buildingStack.peek();
						currentBuilding = lowerBuilding;
						break;
					} else if (buildingStack.isEmpty() && lowerBuilding == 0) {
						max = setMax(max, lastBuilding, count);
						return max;
					}
					currentBuilding = buildingStack.peek();
					if (currentBuilding <= lowerBuilding) {
						while (count > 0) {
							buildingStack.push(lowerBuilding);
							count--;
						}
						lastBuilding = buildingStack.peek();
						currentBuilding = lowerBuilding;						
						break;
					}else{
						lastBuilding = currentBuilding;
						currentBuilding = lowerBuilding;						
					}
				}
			}

		}
		return max;
	}

	private static long setMax(long max, int lastBuilding, int count) {
		long area1 = lastBuilding * count;
		if (area1 > max) {
			max = area1;
		}
		return max;
	}

	/*
	 * public static void main(String[] args) { Scanner in = new
	 * Scanner(System.in); int n = in.nextInt(); int[] h = new int[n]; for (int
	 * h_i = 0; h_i < n; h_i++) { h[h_i] = in.nextInt(); } long result =
	 * largestRectangle(h); System.out.println(result); in.close(); }
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		long[] output = { 21, 30, 26, 12, 12, 9, 9, 9, 5, 4, 5, 5 };
		for (int i = 0; i < total; i++) {
			int n = in.nextInt();
			int[] h = new int[n];
			for (int h_i = 0; h_i < n; h_i++) {
				h[h_i] = in.nextInt();
			}
			long result = largestRectangle(h);
			System.out.println("Actual: " + result + " " + "Expected : " + output[i] + " " + (result == output[i]));
		}
		in.close();
	}

}
