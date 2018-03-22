package com.problems.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://www.hackerrank.com/challenges/poisonous-plants/problem}
 * 
 * This logic deals about only the output left over plants not the days count but in
 * the real problem it's ask for days count so if they ask for output plants time this
 * is efficient
 * @author jawahar
 *
 */
public class PoisonousPlants {

	static Stack<Integer> poisonousPlants(Stack<Integer> plantsStack) {
		Stack<Integer> remainingPlants = new Stack<Integer>();			
		int lastPlant = plantsStack.pop();		
		while (!plantsStack.isEmpty()) {
			int current = plantsStack.peek();
			if (current >= lastPlant) {
				checkRemainingsStackUpdateCount(remainingPlants, lastPlant);
			}
			lastPlant = plantsStack.pop();
			if (plantsStack.isEmpty()) {
				checkRemainingsStackUpdateCount(remainingPlants,lastPlant);
			}
		}
		return remainingPlants;
	}

	private static Stack<Integer> checkRemainingsStackUpdateCount(Stack<Integer> remainingPlants, int lastPlant) {		
		try {
			Integer fromRemainingLast = null;
			do {
				fromRemainingLast = remainingPlants.peek();
				if (fromRemainingLast > lastPlant) {					
					remainingPlants.pop();
				} else {
					break;
				}
			} while (fromRemainingLast > lastPlant);
			remainingPlants.push(lastPlant);
		} catch (EmptyStackException es) {
			remainingPlants.push(lastPlant);
		}
		return remainingPlants;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> plantsStack = new Stack<Integer>();
		for (int p_i = 0; p_i < n; p_i++) {
			plantsStack.push(in.nextInt());
		}
		plantsStack = poisonousPlants(plantsStack);
		System.out.println(plantsStack);
		in.close();
	}

}
