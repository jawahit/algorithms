package com.problems.datastructures.linkedlist;


/**
 * 
 * {@link https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem}
 * 
 * @author jawahar
 *
 */
public class RemoveDuplicatesInSorted {

	public static void main(String args[]) {
		Node nodeA = new Node();
		nodeA.data = 10;
		GetNode(nodeA);
	}

	static Node GetNode(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		if (head == null) {
			return null;
		}
		Node node = head;
		while (node.next != null) {
			if (node.data == node.next.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}

	static class Node {
		int data;
		Node next;
	}

}
