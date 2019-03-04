package com.problems.algorithms.week2.queues;

/**
 * @author Thangaraj Jawahar
 *
 */
public class QueuesOfStringClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-------- using array -----------");
		QueueOfStringsUsingArray stackOfStrings = new QueueOfStringsUsingArray(2);
		stackOfStrings.enQueue("hello");
		System.out.println(stackOfStrings.deQueue());
		stackOfStrings.enQueue("Jawahar");
		System.out.println(stackOfStrings.deQueue());
		stackOfStrings.enQueue("how");
		stackOfStrings.enQueue("are");
		stackOfStrings.enQueue("you");
		System.out.println(stackOfStrings.deQueue());
		System.out.println(stackOfStrings.deQueue());
		System.out.println(stackOfStrings.deQueue());
		while(!stackOfStrings.isEmpty()) {	
			System.out.println(stackOfStrings.deQueue());
		}
		stackOfStrings.enQueue("hello");
		stackOfStrings.enQueue("Jawahar");
		stackOfStrings.enQueue("how");
		stackOfStrings.enQueue("are");
		stackOfStrings.enQueue("you");
		while(!stackOfStrings.isEmpty()) {	
			System.out.println(stackOfStrings.deQueue());
		}
		
		System.out.println("-------- using linked list -----------");
		QueueUsingLinkedList<String> ll = new QueueUsingLinkedList<String>();
		ll.enQueue("hello");
		ll.enQueue("Jawahar");
		System.out.println(ll.deQueue());
		System.out.println(ll.deQueue());
		System.out.println(ll.deQueue());
		ll.enQueue("how");
		ll.enQueue("are");
		ll.enQueue("you");
		ll.enQueue("hello");
		ll.enQueue("Jawahar");
		while(!ll.isEmpty()) {	
			System.out.println(ll.deQueue());
		}
		
		
		System.out.println("-------- using linked list integer -----------");
		QueueUsingLinkedList<Integer> llINt = new QueueUsingLinkedList<Integer>();
		llINt.enQueue(1);
		llINt.enQueue(2);
		System.out.println(llINt.deQueue());
		System.out.println(llINt.deQueue());
		System.out.println(llINt.deQueue());
		llINt.enQueue(3);
		llINt.enQueue(3);
		llINt.enQueue(4);
		llINt.enQueue(5);
		llINt.enQueue(6);
		while(!llINt.isEmpty()) {	
			System.out.println(llINt.deQueue());
		}
	}
}
