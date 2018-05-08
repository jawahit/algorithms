package com.problems.datastructures.linkedlist;



/**
 *  to find the length of the linked list using tortoise and hare runner method
 * 
 * @author jawahar
 *
 */
public class LengthofLinkedList {

	static class Node {
		int data;
		Node next;
	}

	public static void main(String args[]) {
		Node node = new Node();
		node.data = 10;
		getLength(node);
	}

	static int getLength(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		if (head == null) {
			return 0;
		}
		int total = 0;
		Node tortoiseRunner = head;
		Node hareRunner = head;
		int count = 0;
		while (hareRunner.next != null && hareRunner.next.next != null) {
			tortoiseRunner = tortoiseRunner.next;
			hareRunner = hareRunner.next.next;
			count++;
		}
		if (hareRunner.next != null) {
			count++;
			total = count * 2;
		} else {
			total = count * 2;
			total++;
		}
		return total;
	}

}
