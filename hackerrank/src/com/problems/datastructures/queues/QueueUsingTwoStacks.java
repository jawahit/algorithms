package com.problems.datastructures.queues;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
	
	public static void main(String[] args) {
	      Scanner in = new Scanner(System.in);
	      int n = in.nextInt();
	      Stack<Integer> inputStack = new Stack();
	      Stack<Integer> outputStack = new Stack();  
	      for (int i = 0; i < n; i++) {
	            int type = in.nextInt();             
	            if(type == 1){
	              inputStack.push(in.nextInt());    
	            }else{
	                if(outputStack.isEmpty()){
	                  while(!inputStack.isEmpty()){
	                	  outputStack.push(inputStack.pop());
	                  }    
	                }
                  if(type == 2){
                  	outputStack.pop();
                  }else{
                      System.out.println(outputStack.peek());
                  }	                                
	            } 			
		  }}

}
