package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlantsProblem {
	
	static int poisonousCount = 0;

	static Stack<Integer> poisonousPlants(Stack<Integer> plantsStack) {
		int size = plantsStack.size();
		Stack<Integer> poisonPlants = new Stack<Integer>();	
		Stack<Integer> remainingPlants = new Stack<Integer>();	
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				break;
			}
			if (plantsStack.get(i + 1) < plantsStack.get(i)) {
			} else {
				poisonPlants.push(i + 1);
			}
		}
		for(Integer i:plantsStack){			
			remainingPlants.push(plantsStack.get(i));
		}
		poisonousCount = poisonPlants.size();
		return plantsStack;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> plantsStack = new Stack<Integer>();
		int dayCount = 0;
		for (int p_i = 0; p_i < n; p_i++) {
			plantsStack.push(in.nextInt());
		}
		do {
			dayCount++;
			plantsStack = poisonousPlants(plantsStack);
		} while (poisonousCount != 0);
		System.out.println(dayCount - 1);
		in.close();
	}
}
