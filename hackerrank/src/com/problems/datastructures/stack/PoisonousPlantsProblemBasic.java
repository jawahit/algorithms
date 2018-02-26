package com.problems.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author jawahar
 * 
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 * This Solution has a timout issue and it follows normal iteration approach
 *
 */
public class PoisonousPlantsProblemBasic {
	
	static int daysCount = 0;
	static Stack<Integer> remainingPlants = null;		        

	static boolean poisonousPlants(Stack<Integer> plantsStack) {
		remainingPlants = new Stack<Integer>();
		boolean stillPoisonous = false;
		while (plantsStack.size() > 0) {
			if (plantsStack.size() == 1) {
				Integer lastPlant = plantsStack.pop();				
				remainingPlants.push(lastPlant);
				break;
			}
			Integer last = plantsStack.pop();
			Integer beforeLast = plantsStack.peek();
			if (last <= beforeLast) {                								
				remainingPlants.push(last);				
			}else{
				stillPoisonous = true;
			}
		}		
		return stillPoisonous;
	}
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> plantsStack = new Stack<Integer>();
		for (int p_i = 0; p_i < n; p_i++) {
			plantsStack.push(in.nextInt());
		}		
		boolean stillPoisonous = false;
		int count =-1;
		do{
			count++;
			stillPoisonous = poisonousPlants(plantsStack);
			while(remainingPlants.size() != 0){
				plantsStack.push(remainingPlants.pop());
			}
		}while(stillPoisonous);
		System.out.println(count);
		in.close();
	}
}
