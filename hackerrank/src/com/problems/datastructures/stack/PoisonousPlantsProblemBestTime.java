package com.problems.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 * 
 * This solution is best to produce the the output stacks but not 
 * for counting the days
 * 
 * @author jawahar
 *
 */
public class PoisonousPlantsProblemBestTime {

	static int poisonousPlants(Stack<Integer> plantsStack) {
		Stack<Integer> remainingPlants = new Stack<Integer>();
		int daysCount = 1;
		int fullPlantsSize = plantsStack.size();
		boolean allPlantsAreAlive = true;
		while (plantsStack.size() > 0) {
			if (plantsStack.size() == 1) {
				Integer lastPlant = plantsStack.pop();
				try {
					Integer fromRemainingLast = null;
					do {
						fromRemainingLast = remainingPlants.peek();
						if (fromRemainingLast > lastPlant) {
							daysCount++;
							remainingPlants.pop();
						} else {
							break;
						}
					} while (fromRemainingLast > lastPlant);
					remainingPlants.push(lastPlant);

				} catch (EmptyStackException es) {
					remainingPlants.push(lastPlant);
				}
				if (remainingPlants.size() == fullPlantsSize || remainingPlants.size() == 0 || allPlantsAreAlive) {
					daysCount = 0;
					return daysCount;
				}
				break;
			}
			Integer last = plantsStack.pop();
			Integer beforeLast = plantsStack.peek();
			if (last <= beforeLast) {
				allPlantsAreAlive = false;
				try {
					Integer fromRemainingLast = null;
					do {
						fromRemainingLast = remainingPlants.peek();
						if (fromRemainingLast > last) {
							daysCount++;
							remainingPlants.pop();
						} else {
							break;
						}
					} while (fromRemainingLast > last);
					remainingPlants.push(last);

				} catch (EmptyStackException es) {
					remainingPlants.push(last);
				}
			}
		}
		return daysCount;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> plantsStack = new Stack<Integer>();
		for (int p_i = 0; p_i < n; p_i++) {
			plantsStack.push(in.nextInt());
		}
		int result = poisonousPlants(plantsStack);
		System.out.println(result);
		in.close();
	}

}
