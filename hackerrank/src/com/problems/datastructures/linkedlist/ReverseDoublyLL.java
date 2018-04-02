package com.problems.datastructures.linkedlist;



/**
 * 
 * {@link https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem}
 * 
 * @author jawahar
 *
 */
public class ReverseDoublyLL {

	public static void main(String[] args) {
		Node node = new Node();
		node.data = 10;
		Reverse(node);
	}

	static Node Reverse(Node head) {
		if (head == null) {
			return head;
		}
		Node nextNode = null;
		Node prevNode = null;
		Node node = head;
		while (node != null) {
			prevNode = node.prev;
			nextNode = node.next;
			node.next = prevNode;
			node.prev = nextNode;
			prevNode = node;
			node = nextNode;
		}
		// PrevNode contains the backup node so when it reaches null last node is head node for reusing used prevNode reference
		return prevNode;
	}

	static class Node {
		int data;
		Node next;
		Node prev;
	}

}
