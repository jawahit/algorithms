/**
 * 
 */
package com.problems.algorithms.week2.stacks;

import java.util.Stack;

/**
 * @author Thangaraj Jawahar
 *
 */
public class StackOfStringClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-------- using array -----------");
		StackOfStringsUsingArray stackOfStrings = new StackOfStringsUsingArray(2);
		stackOfStrings.push("hello");
		stackOfStrings.push("Jawahar");
		stackOfStrings.push("how");
		stackOfStrings.push("are");
		stackOfStrings.push("you");
		while(!stackOfStrings.isEmpty()) {	
			System.out.println(stackOfStrings.pop());
		}
		stackOfStrings.push("hello");
		stackOfStrings.push("Jawahar");
		stackOfStrings.push("how");
		stackOfStrings.push("are");
		stackOfStrings.push("you");
		while(!stackOfStrings.isEmpty()) {	
			System.out.println(stackOfStrings.pop());
		}
		
		System.out.println("-------- using linked list -----------");
		StackUsingLinkedList<String> ll = new StackUsingLinkedList<String>();
		ll.push("hello");
		ll.push("Jawahar");
		ll.push("how");
		ll.push("are");
		ll.push("you");
		while(!ll.isEmpty()) {	
			System.out.println(ll.pop());
		}

	}

}
