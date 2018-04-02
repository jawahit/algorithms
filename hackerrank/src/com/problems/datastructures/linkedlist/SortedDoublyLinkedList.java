package com.problems.datastructures.linkedlist;



/**
 * {@link https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem}
 * 
 * @author jawahar
 *
 */
public class SortedDoublyLinkedList {

	public static void main(String args[]) {
		Node node = new Node();
		node.data = 10;
		SortedInsert(node, 4);
	}

	static Node SortedInsert(Node head, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (head == null) {
			head = newNode;
			return head;
		}
		Node node = head;
		if (data <= node.data) {
			newNode.next = node;
			node.prev = newNode;
			head = newNode;
			return head;
		}
		while (node.next != null) {
			if (data > node.data) {
				node = node.next;
			} else {
				break;
			}
		}
		if (node.data > data) {
			Node prevNode = node.prev;
			node.prev = newNode;
			newNode.prev = prevNode;
			prevNode.next = newNode;
			newNode.next = node;
		} else {
			node.next = newNode;
			newNode.prev = node;
		}

		return head;
	}

	static class Node {
		int data;
		Node next;
		Node prev;
	}

}
