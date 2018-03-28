package com.problems.datastructures.linkedlist;

public class Reverselinkedlist {

	public static void main(String args[]) {
		Node node = new Node();
		node.data = 10;
	}

	static Node Reverse(Node head) {

		// This is a "method-only" submission.
		// You only need to complete this method.
		if (head == null) {
			return null;
		}
		Node node = head;
		Node prevNode = null;
		while (node != null) {
			Node bkupNode = node.next;
			node.next = prevNode;
			prevNode = node;
			node = bkupNode;
		}
		head = prevNode;
		return head;
	}

	static class Node {
		int data;
		Node next;
	}

}
