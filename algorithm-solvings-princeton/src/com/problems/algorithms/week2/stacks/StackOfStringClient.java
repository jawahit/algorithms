/**
 * 
 */
package com.problems.algorithms.week2.stacks;

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
		StackOfStringsUsingArray<String> stackOfStrings = new StackOfStringsUsingArray(2);
		stackOfStrings.push("hello");
		stackOfStrings.push("Jawahar");
		stackOfStrings.push("how");
		stackOfStrings.push("are");
		stackOfStrings.push("you");
		for(String s : stackOfStrings) {
			System.out.println(s);
		}
		while(!stackOfStrings.isEmpty()) {	
			System.out.println(stackOfStrings.pop());
		}
		stackOfStrings.push("hello");
		stackOfStrings.push("Jawahar");
		stackOfStrings.push("how");
		stackOfStrings.push("are");
		stackOfStrings.push("you");
//		while(!stackOfStrings.isEmpty()) {	
//			System.out.println(stackOfStrings.pop());
//		}
		
		System.out.println("-------- using linked list -----------");
		StackUsingLinkedList<String> ll = new StackUsingLinkedList<String>();
		ll.push("hello");
		ll.push("Jawahar");
		ll.push("how");
		ll.push("are");
		ll.push("you");
		for(String s: ll) {
			System.out.println(s);
		}
		
//		while(!ll.isEmpty()) {	
//			System.out.println(ll.pop());
//		}

	}

}
